import React,{useState} from 'react';
import './share.css'
import questionService from '../../services/questionService';
import { QuestionRequest } from '../../models/QuestionRequest';
import { Question } from '../../models/Question';

export default function Share(){

    const [questionContent,setQuestionContent] = useState({inputValue : ''});

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const  value  = e.target.value;
        setQuestionContent({inputValue : value});
    };

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if(questionContent!=null && questionContent.inputValue.length > 0) {
            const newQuestion = new QuestionRequest(questionContent.inputValue,"shivateja.bandaru@gmail.com");
            questionService.postQuestion('', newQuestion)
            .then((response) => {
                console.log("the question posted is " + response);
                setQuestionContent({inputValue : ''});
            })
            .catch((error) => {
                console.log("question posting failed: " + error);
            });
        }
    };

    return (
        <div data-testid="share-component" className='share'>
            <div className="shareWrapper">
            <form onSubmit={handleSubmit}>
                <div className="shareTop">
                    <img className='shareProfileImg' src="assets/dp.png" alt="" />
                    <input data-testid="shareInput" placeholder="Ask a Question" value={questionContent.inputValue} className='shareInput' onChange={handleChange}/>
                </div>
                <hr className='shareHr'/>
                <div className="shareBottom">
                    <button type ='submit'className='shareButton' >Post Question</button>
                </div>
            </form>
            </div>
        </div>
    )
}