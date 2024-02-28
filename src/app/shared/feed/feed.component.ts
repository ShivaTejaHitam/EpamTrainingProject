import { Component, OnInit } from '@angular/core';
import { QuestionsService } from '../questions.service';
import { Question } from '../question.model';
import { Comment } from '../comment.model';

@Component({
  selector: 'feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  public posts: Question[] = [];
  public postlikes: number = 9;

  constructor(private questionsService: QuestionsService) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
      this.questionsService.getQuestions().subscribe(posts => {
        this.posts = posts.sort((p1, p2) => p1.timestamp - p2.timestamp);
      }
    );
  }
}
