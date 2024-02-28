import { Injectable,EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotifyAnswerService {
  answerPosted = new EventEmitter<void>();
  constructor() { }

  triggerAnswerPosted(){
    console.log('triggerAnswerPosted');
    this.answerPosted.emit();
  }
}
