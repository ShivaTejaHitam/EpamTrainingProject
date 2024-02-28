import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotifyPostService {

  questionPosted = new EventEmitter<void>();
  constructor() { }

  triggerQuestionPosted(){
    console.log('triggerQuestionPosted');
    this.questionPosted.emit();
  }
}
