/**
 * 
 */
package com.student.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentRecordEntity;

/**
 * @author sumit
 *
 */
@Repository
public interface StudentRecordRepository extends CrudRepository<StudentRecordEntity, Integer>{}
