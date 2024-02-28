import {Timestamp}  from "rxjs";
import {Answer} from './answer.model';

export interface Question{
    questionId : number;
    questionContent : string;
    timestamp : number;
    userEmail : string;
    answers : Answer[];
}
