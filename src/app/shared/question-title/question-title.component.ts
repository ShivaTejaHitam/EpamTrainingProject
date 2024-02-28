import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'question-title',
  templateUrl: './question-title.component.html',
  styleUrls: ['./question-title.component.css']
})
export class QuestionTitleComponent implements OnInit {

  @Input() questionTitle : string = '';
  @Input() questionId : number = 0;
  showModal: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  openModal() {
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }
  
}
