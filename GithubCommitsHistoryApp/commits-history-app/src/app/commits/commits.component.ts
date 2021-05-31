import { Component, OnInit } from '@angular/core';
import { Commit } from '../model/commit';
import { CommitsService } from '../service/commits.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-commits',
  templateUrl: './commits.component.html',
  styleUrls: ['./commits.component.css']
})
export class CommitsComponent implements OnInit {

  // username: string;
  // projectName: string;
  isValidProject: boolean = false;

  getProjectForm = new FormGroup({
    username: new FormControl("croudebush15"),
    projectName: new FormControl("GitCommitHistoryApp")    
  })

  listCommits: Commit[];
  constructor(private commitService: CommitsService) { }

  ngOnInit(): void {
    //this.getCommits();
  }

  getCommits(): void{    
    console.log("Is list empty?" + this.listCommits);
    this.commitService.getCommits().subscribe(
      (res: Commit[]) => {
        this.listCommits = res;
        console.log("Get commits: " + this.listCommits);        
      }
    )
  }

  getProject(values): void{
    this.listCommits = [];    
    //console.log(values.username, values.projectName);        
    this.commitService.getProject(values.username, values.projectName)    
    
    setTimeout(() => {
      this.getCommits();
  }, 3000);
  }

}
