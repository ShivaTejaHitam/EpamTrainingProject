export class Comment{

    commentContent :string;
    answerId : number;
    userEmail : string;

    constructor(commentContent :string, answerId :number, userEmail :string){
        this.commentContent = commentContent;
        this.answerId = answerId;
        this.userEmail = userEmail;
    }
}