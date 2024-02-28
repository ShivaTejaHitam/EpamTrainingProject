import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { QuestionsService } from '../questions.service';
import { NotifyPostService } from '../notify-post.service';

@Component({
  selector: 'share',
  templateUrl: './share.component.html',
  styleUrls: ['./share.component.css']
})
export class ShareComponent implements OnInit {

  questionContent = new FormControl('');
  
  constructor(private questionsService : QuestionsService, private notifyPostService : NotifyPostService) { }

  ngOnInit(): void {
  }

  postQuestion() {

    if(this.questionContent.value!.length > 0) {

      let question = {'questionContent' : this.questionContent.value,'userEmail' : 'shivateja.bandaru@gmail.com'};
      this.questionsService.postQuestion(question).subscribe(data => {
        console.log('Question Posted : ' + data);
        this.notifyPostService.triggerQuestionPosted();
      });

      this.questionContent = new FormControl('');

    }

  }
}