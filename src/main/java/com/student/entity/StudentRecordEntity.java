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

/**
 * @author sumit
 *
 */

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

}
