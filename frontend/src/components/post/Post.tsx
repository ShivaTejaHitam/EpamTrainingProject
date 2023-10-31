import React from 'react';
import { useState ,useEffect } from 'react';
import { useNavigate } from "react-router-dom";


import Comments from '../comments/Comments';
import './post.css';
import { Question } from '../../models/Question';
import { Answer } from '../../models/Answer';
import likeService from '../../services/likeService';
import { LikeRequest } from '../../models/LikeRequest';


interface PostProps{
    question : Question;
    answer : Answer;
    isFeed : boolean;
}

export default function Post({question,answer, isFeed} : PostProps) {

    const filledHeartUrl = 'assets/filled_heart.png';
    const emptyHeartUrl = 'assets/empty_heart.png'; 
    const username = answer.userEmail.split('@')[0];
    let areCommentsVisible : boolean = false;
    const [likes,setLikes] = useState(0);
    const [likeIconUrl,setLikeIconUrl] = useState(emptyHeartUrl);
    const navigate = useNavigate();
    
    

    function navigateToQuestionDetailFeed(question : Question){
        console.log('navigating', question);
        navigate('questionDetails',{state : question});
    }

    useEffect(() => {
        if(answer.likes != null && answer.likes.length > 0 ){
            setLikes(answer.likes.length);
            if(answer.likes.filter(like => (like.answerId == answer.answerId && like.userEmail == 'shivateja.bandaru@gmail.com')).length > 0 ){
                setLikeIconUrl(filledHeartUrl);
            }
        }
    },[answer.answerId,answer.likes]);

    function toggleLike(){
        likeIconUrl === emptyHeartUrl ? setLikeIconUrl(filledHeartUrl) : setLikeIconUrl(emptyHeartUrl);;
        likeIconUrl === emptyHeartUrl ? dislikeAnswer() : likeAnswer();
    }

    function likeAnswer(){
        let likeRequest = new LikeRequest(answer.answerId,"shivateja.bandaru@gmail.com");
        likeService.likeAnswer('',likeRequest)
        .then(response => setLikes(likes +1) )
        .catch(error => console.log("Sorry like  Failed"));
    }

    function dislikeAnswer(){
        likeService.dislikeAnswer('',1)
        .then(response => setLikes(likes - 1))
        .catch(error => console.log("Sorry dislike Failed"));
    }

    function toggleCommentsVisibility(){
        areCommentsVisible = !areCommentsVisible;
    }

    return (
        <div className='post'>
        <div className="postWrapper">
        <div className="postTop">
            <div className="postTopLeft">
                <img className='postProfileImg'
                src="assets/persons/shiva.jpg" 
                alt="" />
                <span className="postUsername">
                    {username}
                </span>
                <span className="postDate">{answer.timestamp}</span>
            </div>
        </div>
        <div className="postCenter">
           {isFeed && <a  onClick={() => navigateToQuestionDetailFeed(question)}> <strong>{question.questionContent}</strong></a> }
            <p></p>
            <span className="postText">{answer.answerContent}</span>
        </div>
        <div className="postBottom">
            <div className="postBottomLeft">
            <img className='likeIcon' src={likeIconUrl}  alt="" onClick={toggleLike}/>
            <span className="postLikeCounter">{likes}</span>
            </div> 
            <div className="postBottomRight">
            <span className="postCommenttext" onClick={toggleCommentsVisibility}>comments</span>
            </div>
        </div>
        {areCommentsVisible && <Comments comments = {answer.comments}/>}
    </div>
    </div>
    )
}
