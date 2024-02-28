import {Comment} from './comment.model';

export interface Answer{
    answerId : number,
    answerContent :string,
    questionId : number,
    userEmail : string,
    timestamp : number,
    comments : Comment[]
}
