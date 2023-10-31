import React from 'react';
import  './questionForYou.css';

export default function QuestionForYou(){
    return (
        <li className="rightbarFriend">
            <div className="rightbarProfileImgContainer">
                <span className="rightbarOnline"></span>
            </div>
            <a className="rightbarUsername">questionContent</a>
        </li>
    )
}