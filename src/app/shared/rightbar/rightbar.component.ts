import { Component, OnInit } from '@angular/core';
import { Question } from '../question.model';
import {QuestionsService } from '../questions.service';
import { NotifyPostService } from '../notify-post.service';

@Component({
  selector: 'rightbar',
  templateUrl: './rightbar.component.html',
  styleUrls: ['./rightbar.component.css'],
})
export class RightbarComponent implements OnInit {
  public questionsForYou : Question[] = [];

  constructor(private questionsService : QuestionsService, private notifyPostService : NotifyPostService) { }

  ngOnInit(): void {
    this.populateQuestionsForYou();
    this.notifyPostService.questionPosted.subscribe(() => this.populateQuestionsForYou());
  }

  populateQuestionsForYou() : void {
    this.questionsService.getQuestions().subscribe( (posts) => {
      this.questionsForYou = posts;
      this.questionsForYou = this.questionsForYou.filter(post => post.answers==null || post.answers.length == 0);
    });
  }
}
