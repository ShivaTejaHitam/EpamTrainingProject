export class Answer{

    answerContent :string;
    questionId : number;
    userEmail : string;

    constructor(answerContent :string, questionId :number, userEmail :string){
        this.answerContent = answerContent;
        this.questionId = questionId;
        this.userEmail = userEmail;
    }
}
