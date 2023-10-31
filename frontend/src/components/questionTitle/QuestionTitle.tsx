import React,{useState} from 'react';
import Modal from '../modal/Modal';
import './questionTitle.css';
import { QuestionProp } from '../../models/QuestionProp';




export default function QuestionTitle({question} : QuestionProp){
    const [modalState,setModalState] = useState(false);

    function toggleModalState(){
        setModalState(!modalState);
    }   

    return (
        <div className='questionTitle'>
            <div className="questionTitleWrapper">
            <div className="questionTitleBottom">
                <strong>{question.questionContent}</strong>
            </div>
            <button className="answerButton" onClick={toggleModalState} >Answer</button>
            {modalState && <Modal question={question} toggleModalState={toggleModalState}/>}
            </div>
        </div>
    )
}
