import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';
import { StudentData } from './student-data';

@Injectable({
  providedIn: 'root'
})

export class StudentApiService {

  private _baseUrl: string = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  // Get students data
  getStudentList(): Observable<Student[]> {
    return this.http.get<Student[]>(this._baseUrl + "/view");
  }

  // Get  By ID students data
  getStudentById(): Observable<Student[]> {
    return this.http.get<Student[]>(this._baseUrl + "/view");
  }

  // Add students data
  addStudent(formData)  {
    return this.http.post<any>(this._baseUrl + "/add",formData);
  }

  // Update students data
  updateStudent(): Observable<Student[]> {
    return this.http.get<Student[]>(this._baseUrl + "/view");
  }

  // Delete students data
  deleteStudent(): Observable<Student[]> {
    return this.http.get<Student[]>(this._baseUrl + "/view");
  }

  errorHandler(error: HttpErrorResponse){
    return Observable.throw(error.message || "Server Error")
  }
}
