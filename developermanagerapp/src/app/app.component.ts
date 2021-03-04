import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Developer } from './developer';
import { DeveloperService } from './developer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public developers: Developer[];


  constructor(private developerService: DeveloperService){}

  ngOnInit() {
    this.getDevelopers();
  }
  
  public getDevelopers(): void {
    this.developerService.getAllDevelopers().subscribe(
      (response: Developer[]) => {
        this.developers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
