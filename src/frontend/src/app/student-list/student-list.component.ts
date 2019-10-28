import { Component, OnInit, Inject } from '@angular/core';
import { StudentService } from '../services/student.service';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  public studentsData = [];
  responseData: any;
  viewData:any;
  dataSource: any;

  displayedColumns: string[] = ['position', 'Name', 'Course', 'Action'];
  viewDatas: any;
  course: any;

  constructor(public studentService: StudentService) { }

  ngOnInit() {
    this.showData();
  }


  showData() {
    this.studentService.getStudentList()
      .subscribe(response => {
        this.studentsData = response;
        console.table(this.studentsData);
        console.log(this.studentsData);
        this.dataSource = this.studentsData;
      });
  }

  deleteById(id) {
    console.log('------------>' + id);
    this.studentService.deleteStudentById(id)
      .subscribe(response => {
        this.responseData = response;
        console.log(this.studentsData);
        this.dataSource = this.studentsData;
        this.showData();
      });
  }

  viewBox(id){
    const view= [];
    this.studentService.viewStudentById(id)
    .subscribe(response => {
      this.responseData = response;
      view.push(this.responseData);
      this.viewDatas=view;
      console.log(view);
      console.log('this.viewData------>'+Object.keys(response));

      console.log('this.viewData------>'+Object.values(response));
    });
  }

  viewBox1(id){
    this.studentService.viewStudentById(id)
    .subscribe(response => {
      this.viewData = response;
      this.viewDatas = this.viewData.name;
      this.course = this.viewData.course;
      console.log(this.viewData);
      console.log('this.viewData------>'+Object.keys(response));

      console.log('this.viewData------>'+Object.values(response));
    });
  }
}