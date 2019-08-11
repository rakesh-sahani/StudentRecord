package com.student.service;

import java.util.Optional;

import com.student.entity.StudentRecordEntity;

public interface StudentRecordService {
	
	public Iterable<StudentRecordEntity> getAll();

	public Optional<StudentRecordEntity> getById(int id);
	
	public String add(StudentRecordEntity studentRecordEntity);
	
	public String update(StudentRecordEntity studentRecordEntity);
	
	public String deleteById(int id);
}
