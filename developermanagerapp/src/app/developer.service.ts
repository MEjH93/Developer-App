import { Injectable } from '@angular/core';
import {Developer} from './developer';
import {Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class DeveloperService{
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    public getAllDevelopers(): Observable<Developer[]> {
        return this.http.get<any>(`${this.apiServerUrl}/developer/all`);
    }

    public saveNewDeveloper(developer: Developer): Observable<Developer> {
        return this.http.post<any>(`${this.apiServerUrl}/developer`, developer);
    }

    public getDeveloperByID(developerId: number): Observable<Developer> {
        return this.http.get<any>(`${this.apiServerUrl}/developer/${developerId}`);
    }

    public updateDeveloper(developer: Developer): Observable<Developer> {
        return this.http.put<any>(`${this.apiServerUrl}/developer/update`, developer);
    }
    public deleteDeveloper(developerId: number): Observable<void> {
        return this.http.delete<any>(`${this.apiServerUrl}/developer/delete/${developerId}`);
    }
    }
