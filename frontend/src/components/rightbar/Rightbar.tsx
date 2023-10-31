import React from 'react';
import QuestionForYou from '../questionForYou/QuestionForYou';
import './rightbar.css';

export default function Rightbar(){

    return ( 
        <div className="rightbar">             
            <h4 className="rightbarTitle">Questions For you</h4>
            <ul className="rightbarfriendList"> 
             {/*   {Questions.map((q)=>(
                    <QuestionForYou key={q.id} question={q}/>
             ))}   */}
             <QuestionForYou/>
            </ul>
        </div>
    )
}