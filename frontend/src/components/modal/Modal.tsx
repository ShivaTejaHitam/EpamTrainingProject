import React,{useState} from 'react';
import './modal.css';
import { Question } from '../../models/Question';

interface ModalProp{
    question : Question;
    toggleModalState : () => void;
}

export default function Modal({question, toggleModalState} : ModalProp){

    const rows = 20;
    const columns = 70;

    const [answerContent,setAnswerContent] = useState('');

    const handleChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
        const  value  = e.target.value;
        setAnswerContent(value);
    };

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if(answerContent !=null && answerContent.length > 0){
            console.log('the answer posted is: '+answerContent);
            toggleModalState();
        }
    };

    return (
        <div className="modal">
            <div className="modal-content">
            <button id="closeButton" onClick={toggleModalState}>X</button>
            <form onSubmit={handleSubmit}>
                <h2>{question.questionContent}</h2>
                <textarea rows={rows} cols={columns} placeholder="Write your answer" onChange={handleChange}></textarea>
                <button id='postButton'>Post Answer</button>
            </form>
            </div>
        </div>
    )
}