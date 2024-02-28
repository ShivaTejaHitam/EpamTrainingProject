import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'question-for-you',
  templateUrl: './question-for-you.component.html',
  styleUrls: ['./question-for-you.component.css']
})
export class QuestionForYouComponent implements OnInit {
  @Input() questionContent : string = '';
  constructor() { }

  ngOnInit(): void {
  }

}
