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


  getProject(username, projectName){
    console.log("get project in service clicked" + username + projectName);
    const url = "http://localhost:8080/commits/" + username + "/" + projectName;  
    console.log(url);  
    this.http.get(url, { observe: 'response' }).subscribe(
      result => {
        if(result.status == 200){          
          console.log("Status: " + result.status)
          
        }
        else console.log("Project not loaded.")  
                 
      })
    ;
  }
  
  getCommits(): Observable<Commit[]>{
    const url = "http://localhost:8080/commits";
    return this.http.get<Commit[]>(url).pipe(
      map((res) => {   
        //console.log(res);   
        
        this.commits = JSON.parse(JSON.stringify(res));
        
        return this.commits;
      })
    );
  } 
}
