/**
 * 
 */
package com.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.student.config.AppConstants;
import com.student.entity.StudentRecordEntity;
import com.student.service.StudentRecordService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(AppConstants.API_V1)
public class StudentRecordController {

	@Autowired
	private StudentRecordService studentRecordService;

	ObjectMapper mapper = new ObjectMapper();
	
//	View All List of Records
	@GetMapping(value = "/view")
	public ResponseEntity<Object> getAll() {
		List<StudentRecordEntity> listData = new ArrayList<>();
		studentRecordService.getAll().forEach(listData::add);
		ObjectNode node = mapper.createObjectNode();
		try {
			if (listData.isEmpty()) {
				node.put("response", AppConstants.NO_DATA);
				return new ResponseEntity<>(node, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(listData, HttpStatus.OK);

		} catch (Exception e) {
			node.put("response", AppConstants.ERRORS);
			return new ResponseEntity<>(node, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//	View Records By Id
	@GetMapping(value = "/view/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Optional<StudentRecordEntity> listData = studentRecordService.getById(id);
		ObjectNode node = mapper.createObjectNode();
		try {
			if (listData.isPresent()) {
				return new ResponseEntity<>(listData, HttpStatus.OK);
			}
			node.put("response", AppConstants.NO_DATA);
			return new ResponseEntity<>(node, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			node.put("response", AppConstants.ERRORS);
			return new ResponseEntity<>(node, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
//	Add New Record
	@PostMapping(value = "/add")
	public ResponseEntity<Object> add(@RequestBody StudentRecordEntity studentRecordEntity)
	{
		String response = studentRecordService.add(studentRecordEntity);
		ObjectNode node = mapper.createObjectNode();		
			if(response.equalsIgnoreCase(AppConstants.DATA_ALREADY_EXISTS))
			{
				node.put("response", response);
				return new ResponseEntity<>(node,HttpStatus.CREATED);
			}
			else {
				node.put("response",response);
				return new ResponseEntity<>(node,HttpStatus.OK);
			}	
	}
	
//	Update Record
	@PutMapping(value = "/update")
	public ResponseEntity<Object> update(@RequestBody StudentRecordEntity studentRecordEntity)
	{
		String response = studentRecordService.update(studentRecordEntity);
		ObjectNode node = mapper.createObjectNode();		
			if(response.equalsIgnoreCase(AppConstants.DATA_UPDATED))
			{
				node.put("response", response);
				return new ResponseEntity<>(node,HttpStatus.OK);
			}
			else {
				node.put("response",response);
				return new ResponseEntity<>(node,HttpStatus.BAD_REQUEST);
			}	
	}
	
//	Delete Record
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id)
	{
		String response = studentRecordService.deleteById(id);
		ObjectNode node = mapper.createObjectNode();		
			if(response.equalsIgnoreCase(AppConstants.DATA_DELETED))
			{
				node.put("response", response);
				return new ResponseEntity<>(node,HttpStatus.OK);
			}
			else {
				node.put("response",response);
				return new ResponseEntity<>(node,HttpStatus.BAD_REQUEST);
			}	
	}
}
