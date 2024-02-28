import { Component, OnInit ,Input} from '@angular/core';
import {AnswersService } from '../answers.service';
import { Answer } from '../answer.model';
import { NotifyAnswerService } from '../notify-answer.service';

@Component({
  selector: 'question-detail-feed',
  templateUrl: './question-detail-feed.component.html',
  styleUrls: ['./question-detail-feed.component.css']
})
export class QuestionDetailFeedComponent implements OnInit {

  @Input() public questionId : number = 0;
  @Input() public questionTitle : string ='';
  public answers : Answer[] = [];
  public postlikes : number = 9;

  constructor(private answersService : AnswersService,private notifyAnswerService : NotifyAnswerService) { }

  ngOnInit(): void {
    this.loadData();
    this.notifyAnswerService.answerPosted.subscribe(() => this.loadData());
  }

  loadData(){
    this.answersService.getAnswers().subscribe(answers  => {
      this.answers = answers.filter(answer => answer.questionId == this.questionId).sort((a1, a2) =>  a1.timestamp - a2.timestamp);
    });    
  }
}


