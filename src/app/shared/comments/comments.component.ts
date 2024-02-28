import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Comment as CommentModel } from '../comment.model';
import { Comment } from '../comment';
import { CommentsService } from '../comments.service';

@Component({
  selector: 'comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  @Input() answerId: number = 0;
  @Output() commentPostedEvent = new EventEmitter<void>();
  comments: CommentModel[] = [];
  commentContent = new FormControl('');
  errorMessage: string = '';

  constructor(private service: CommentsService) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.service.getComments().subscribe(comments => {
      this.comments = comments.filter(comment => comment.answerId == this.answerId).sort((c1, c2) => c1.timestamp - c2.timestamp);
    });
  }

  postComment() {
    if (this.commentContent.value == null || this.commentContent.value!.length == 0) {
      this.errorMessage = "Comment cannot be empty";
      return;
    }

    let comment = new Comment(this.commentContent.value!, this.answerId, "shivateja.bandaru@gmail.com");
    this.service.postComment(comment).subscribe(response => {
      console.log(response);
      this.commentContent = new FormControl('');
      this.commentPostedEvent.emit();
      this.loadData();
    }, err => {
      console.log("An error has occurred" + err);
    });
  }
}
