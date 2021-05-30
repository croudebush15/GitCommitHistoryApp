import { Component, OnInit } from '@angular/core';
import { CommitsService } from '../service/commits.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private commitService: CommitsService) { }

  ngOnInit(): void {
    this.getProject();
  }

  getProject(): void{
    console.log("Getting project...")
    this.commitService.getProject();
  }

}
