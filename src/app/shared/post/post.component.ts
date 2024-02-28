import { Component, OnInit, Input } from '@angular/core';
import { Comment } from '../comment.model';
import { LikesService } from '../likes.service';
import { Like as LikeModel } from '../like.model';
import { Like } from '../like';

@Component({
  selector: 'post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() questionId: number = 0;

  @Input() answerId: number = 0;

  @Input() questionContent: string = '';

  @Input() answerContent: string = '';

  @Input() timestamp: string = '';

  @Input() userEmail: string = '';

  @Input() comments: Comment[] = [];

  likes: LikeModel[] = [];

  commentsCount : number =0 ;

  commentsVisible: boolean = false;

  questionDetailRoutePath: string = '/question';

  questionDetails: any = {};

  likeIconPath : string = '';

  emptyHeartIconPath : string = '/assets/empty_heart.png';

  filledHeartIconPath : string = '/assets/filled_heart.png';

  currentUserLikeObject : LikeModel | null = null;

  constructor(private likesService : LikesService) { }

  ngOnInit(): void {
    this.questionDetails = { 
      questionId : this.questionId,
      questionContent : this.questionContent
    };
    this.commentsCount = this.comments.length;
    this.loadLikes();
  }

  toggleCommentsVisibility() {
    this.commentsVisible = !this.commentsVisible
  }

  incrementCommentCount(){
    this.commentsCount++;
  }

  decrementCommentCount(){
    this.commentsCount--;
  }

  toggleLike(){
    if(this.likeIconPath == this.filledHeartIconPath){
      this.dislikeAnswer();
    }
    else if(this.likeIconPath == this.emptyHeartIconPath){
      this.likeAnswer();
    }
  }

  private likeAnswer(){
    this.likeIconPath = this.filledHeartIconPath;
    let like  = new Like(this.answerId,'shivateja.bandaru@gmail.com');
    this.likesService.likeAnswer(like).subscribe(res => {
      this.loadLikes();
    });
  }

  private dislikeAnswer(){
      this.likesService.disLikeAnswer(this.currentUserLikeObject!.likeId).subscribe(res => {
        this.loadLikes();
    });
  }

  private loadLikes(){
    this.likesService.getLikes().subscribe((likes)=>{
      this.likes = likes.filter(like => like.answerId == this.answerId);
      this.getCurrentUserLikeObject();
      this.likeIconPath = this.currentUserLikeObject != null ? this.filledHeartIconPath : this.emptyHeartIconPath;
    });
  }

  private getCurrentUserLikeObject(){
    const currentUserLikes = this.likes.filter(like => like.userEmail == 'shivateja.bandaru@gmail.com');
    if(currentUserLikes != null && currentUserLikes.length > 0){
      this.currentUserLikeObject = currentUserLikes[0];
    }
    else{
      this.currentUserLikeObject = null;
    }
  }
}
