import { Comment } from "./Comment";
import {Like} from "./Like";

export interface Answer{
    answerId : number;
    answerContent :string;
    questionId : number;
    userEmail : string;
    timestamp : number;
    comments : Comment[];
    likes : Like[];
}