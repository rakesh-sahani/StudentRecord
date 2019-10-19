import { Component, OnInit } from '@angular/core';
import { StudentApiService } from './student-api.service';
import { Student } from './student';
import { StudentData } from './student-data';
import { FormGroup,FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Student Record';

  public studentsData = [];
  public errorMsg;
  
  constructor(public studentService: StudentApiService,private formBuil : FormBuilder) { }

  studentForm = this.formBuil.group({
    id : [''],
    name : [''],
    course : [''],
  });


  ngOnInit() {
    this.studentService.getStudentList()
      .subscribe(response => this.studentsData = response,
        error => this.errorMsg = error);

  }

  onSubmit(){
    console.log(this.studentForm);
    this.studentService.addStudent(this.studentForm.value)
    .subscribe( 
      data =>{ 
        console.log('Success...!!',data);
        this.view();
    },
      error => console.error('Error...!!',error)
    )
   
  }

  view(){
    console.log('-------view-----');
    this.studentService.getStudentList()
    .subscribe( 
      response => console.log('Success...!!',response),
      error => console.error('Error...!!',error)   
    )
  }

  

}
