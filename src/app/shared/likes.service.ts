import { HttpClient , HttpHeaders, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Like } from './like';
import { Like as LikeModel } from './like.model';

@Injectable({
  providedIn: 'root'
})
export class LikesService {

  private baseUrl: string = "http://localhost:8092/likes";

  constructor(private http : HttpClient) { }

  getLikes() : Observable<LikeModel[]>{
    return this.http.get<LikeModel[]>(this.baseUrl);
  }

  likeAnswer(like : Like){
    return this.http.post(this.baseUrl,like);
  }

  disLikeAnswer(likeId : number){
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const params = new HttpParams().set('likeId',likeId);
    return this.http.delete(this.baseUrl,{headers,params});
  }
}