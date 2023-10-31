import React from 'react';
import './comments.css'
import { Comment } from '../../models/Comment';

interface CommentProps{
    comments? : Comment[];
}

export default function Comments({comments} : CommentProps){

    return (
    <>
        <hr className='shareHr'/>
        <div className="comments">
            <div className="comments-content">
            <span>
                <input placeholder="Write your comment" className="commentInput"/>
                <button id='postButton' >Post Comment</button>
            </span>
            <hr className='shareHr'/>
            <div>
                No comments Yet
            </div>
            <div>
                <strong>Shivateja</strong> <span>12:30 pm</span>
                <p>A very great comment</p>
                <hr className='shareHr'/>
            </div>
            </div>
        </div>
    </>
    )
}
