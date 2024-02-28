import { Component, OnInit ,EventEmitter , Output , Input} from '@angular/core';
import { FormControl } from '@angular/forms';
import { AnswersService } from '../answers.service';
import { Answer } from '../answer';
import { NotifyAnswerService } from '../notify-answer.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  @Input() questionTitle = '';
  @Input() questionId : number = 0;
  @Output() closeModalEvent = new EventEmitter<boolean>();
  answerContent = new FormControl('');
  errorMessage : string = '';

  constructor(private answersService : AnswersService,private notifyAnswerService : NotifyAnswerService){}

  closeModal() {
    this.closeModalEvent.emit(true);
  }
  
  postAnswer() : void {

    if(this.answerContent.value == null || this.answerContent.value!.length == 0) {
      this.errorMessage = "Answer cannot be empty";
      return;
    }

    let answer = new Answer(this.answerContent.value!,this.questionId,"shivateja.bandaru@gmail.com");
      console.log("answer to be posted : " + this.questionId + " " + this.answerContent.value);
      this.answersService.postAnswer(answer).subscribe(response => {
        console.log(response);
        this.closeModalEvent.emit(true);
        this.notifyAnswerService.triggerAnswerPosted();
      },error => {
        console.log("An error has occurred" + error);
      });
  }
}
