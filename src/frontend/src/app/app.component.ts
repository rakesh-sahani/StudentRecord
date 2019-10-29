import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { StudentService } from './services/student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontend';

  course = ['MCA', 'MBA'];
  studentForm: FormGroup;
  addInputBox: any;
  responseData: any;

  constructor(private formBuilder: FormBuilder, public studenService: StudentService, private router: Router) {

    this.studentForm = this.formBuilder.group({
      id: [''],
      name: [''],
      course: [''],
      studentSubjects: this.formBuilder.array([]),
    });

  }

  ngOnInit() {
    this.addInputBox = this.studentForm.controls.studentSubjects as FormArray;
    this.addInputBox.push(this.formBuilder.group({
      id: [''],
      subjectName: [''],
    }));
  }

  addStudent() {
    this.studenService.addStudent(this.studentForm.value)
      .subscribe(data => {
        this.responseData = data;
        console.log(this.responseData);
        window.location.reload();
      });
  }

  addBox() {
    this.addInputBox = this.studentForm.controls.studentSubjects as FormArray;
    this.addInputBox.push(this.formBuilder.group({
      id: [''],
      subjectName: [''],
    }));

  }

  removeBox(i: any) {
    if (i == 0)
      alert('Not Deleted');
    else
      this.addInputBox.removeAt(i);
  }

}
