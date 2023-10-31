import { Answer } from "./Answer";

export interface Question{
    questionId : number;
    questionContent : string;
    timestamp : string;
    userEmail : string ;
    answers : Answer[];
}