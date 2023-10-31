export class LikeRequest{
    answerId : number;
    userEmail : string;

    constructor(answerId : number, userEmail : string){
        this.answerId = answerId;
        this.userEmail = userEmail;
    }
}