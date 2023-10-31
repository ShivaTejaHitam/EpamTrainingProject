export class CommentRequest{
    answerId : number;
    commentContent : string;
    userEmail : string;

    constructor(commentContent : string, answerId : number, userEmail : string){
        this.commentContent = commentContent;
        this.answerId = answerId;
        this.userEmail = userEmail;
    }
}