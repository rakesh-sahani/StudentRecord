/**
 * 
 */
package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRecordEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_course")
	private String course;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_record_entity_id", nullable = false, updatable = false)
	private List<StudentSubjectsEntity> studentSubjects = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<StudentSubjectsEntity> getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubjectsEntity> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	@Override
	public String toString() {
		return "StudentRecordEntity [id=" + id + ", name=" + name + ", course=" + course + ", studentSubjects="
				+ studentSubjects + "]";
	}
	
	

}
