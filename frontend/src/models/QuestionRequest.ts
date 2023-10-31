
export class QuestionRequest{
    
    questionContent : string;
    userEmail : string;

    constructor ( questionContent : string, userEmail : string){
        this.questionContent = questionContent;
        this.userEmail  = userEmail;
    }
}
