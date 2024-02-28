import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Answer } from './answer';
import { Answer as AnswerModel } from './answer.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AnswersService {

  private baseUrl : string = "http://localhost:8090/answers";

  constructor(private http : HttpClient) { }

  postAnswer(answer : Answer) : Observable<Answer>{
    return this.http.post<Answer>(this.baseUrl,answer);
  }

  getAnswers() : Observable<AnswerModel[]>{
    return this.http.get<AnswerModel[]>(this.baseUrl);
  }

}
