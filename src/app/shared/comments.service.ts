import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Comment } from './comment';
import { Comment as CommentModel } from './comment.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  private baseUrl : string = "http://localhost:8091/comments";

  constructor(private http : HttpClient) { }

  postComment(answer : Comment) : Observable<Comment>{
    return this.http.post<Comment>(this.baseUrl,answer);
  }

  getComments() : Observable<CommentModel[]>{
    return this.http.get<CommentModel[]>(this.baseUrl);
  }

  editComment(comment : Comment) : Observable<Comment> {
    return this.http.put<Comment>(this.baseUrl,comment);
  }

  deleteComment(commentId : number) {
    return this.http.delete<CommentModel>(this.baseUrl);
  }

}
