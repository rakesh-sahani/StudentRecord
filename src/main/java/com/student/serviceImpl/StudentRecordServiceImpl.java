
package com.student.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.config.AppConstants;
import com.student.entity.StudentRecordEntity;
import com.student.repository.StudentRecordRepository;
import com.student.service.StudentRecordService;

@Service
public class StudentRecordServiceImpl implements StudentRecordService {

	@Autowired
	private StudentRecordRepository studentRecordRepository;
	
	@Override
	public Iterable<StudentRecordEntity> getAll() {
		// TODO Auto-generated method stub
		return studentRecordRepository.findAll();
	}

	@Override
	public Optional<StudentRecordEntity> getById(int id) {
		// TODO Auto-generated method stub
		return studentRecordRepository.findById(id);
	}

	@Override
	public String add(StudentRecordEntity studentRecordEntity) {
		// TODO Auto-generated method stub	
		Optional<StudentRecordEntity> listData = getById(studentRecordEntity.getId());
		String response="";
			if(listData.isPresent())
			{
				response=AppConstants.DATA_ALREADY_EXISTS;
				return response;
			}
			else {
				studentRecordRepository.save(studentRecordEntity);
				response=AppConstants.DATA_SAVED;
				return response;
			}
	}

	@Override
	public String update(StudentRecordEntity studentRecordEntity) {
		// TODO Auto-generated method stub	
				Optional<StudentRecordEntity> listData = getById(studentRecordEntity.getId());
				String response="";
					if(listData.isPresent())
					{
						studentRecordRepository.save(studentRecordEntity);
						response=AppConstants.DATA_UPDATED;
						return response;
					}
					else {
						response=AppConstants.NO_DATA;
						return response;
					}
	}

	@Override
	public String deleteById(int id) {
		Optional<StudentRecordEntity> listData = getById(id);
		String response="";
			if(listData.isPresent())
			{
				studentRecordRepository.deleteById(id);
				response=AppConstants.DATA_DELETED;
				return response;
			}
			else {
				response=AppConstants.NO_DATA;
				return response;
			}
	}
	
	
	

}
