
import React from 'react';
import {useLocation} from 'react-router-dom'

import './questionDetailFeed.css';
import Share from '../share/Share';
import QuestionTitle from '../questionTitle/QuestionTitle';
import { Question } from '../../models/Question';
import Post from '../post/Post';

export default function QuestionDetailFeed(){

    const location = useLocation();
    const question : Question = location.state as Question;

    return (
        <div className="question-detail-feed">
            <div className="question-feedWrapper">
            <QuestionTitle question={question}/>
            { question.answers.length > 0 ? 
              question.answers.map(a  => <Post key = {a.answerId} question = {question} answer={a} isFeed={false}/>) 
           : <div>Be the first one to Answer</div>} 
            </div>
        </div>
    )
}
