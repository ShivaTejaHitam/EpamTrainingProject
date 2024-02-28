import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Question} from './question.model';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class QuestionsService {
    private baseUrl: string = "http://localhost:8099/questions";

    constructor(private http: HttpClient){}

    getQuestions() : Observable<Question[]>{
        return this.http.get<Question[]>(this.baseUrl);
    }

    postQuestion(question : any) : Observable<any>{
        const headers = {'content-type': 'application/json'};
        const body = JSON.stringify(question);
        console.log(body);
        return this.http.post(this.baseUrl,body,{'headers':headers});
    }
}
