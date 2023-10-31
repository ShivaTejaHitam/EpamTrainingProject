import React from 'react'

import "./questionDetails.css"
import Topbar from "../../components/topbar/Topbar";
import Leftbar from "../../components/leftbar/Leftbar";
import Rightbar from "../../components/rightbar/Rightbar";
import QuestionDetailFeed from '../../components/questionDetailFeed/QuestionDetailFeed';

export default function QuestionDetails(){
    return (
        <>
        <Topbar/>
        <div className="questionDetailsContainer">
            <Leftbar/>
            <QuestionDetailFeed/>
            <Rightbar/>
        </div>
        </>
    )
}