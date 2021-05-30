import { Injectable } from '@angular/core';
import { Commit } from '../model/commit';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CommitsService {

  commits: Commit[];

  constructor(private http: HttpClient) { }


  getProject(){
    
    const url = "localhost:8080/commits/Xris007/Intg-eSportsAPI";
    console.log("is working?");
    this.http.get(url, { observe: 'response' }).pipe(
      map((result) => {
        if(result.status == 200){
          //this.commits = JSON.parse(JSON.stringify(result));
          console.log("Status: " + result.status);
        }
        else console.log("failed")                
      })
    );
  } 
}
