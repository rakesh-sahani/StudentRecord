import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { StudentModal } from '../interfaces/student-modal';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private _baseUrl: string = 'http://localhost:8080/api/v1';

  constructor(private http : HttpClient) { }


  // Get students data
  getStudentList(): Observable<StudentModal[]> {
    return this.http.get<StudentModal[]>(this._baseUrl + "/view");
  }

  viewStudentById(studentById : any) {
    return this.http.get(this._baseUrl + "/view/"+studentById);
  }

  addStudent(studentData) {
    return this.http.post<any>(this._baseUrl + "/add",studentData);
  }

  deleteStudentById(studentById : any) {
    return this.http.delete(this._baseUrl + "/delete/"+studentById);
  }

  
}
