
package com.student.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentRecordEntity;

@Repository
public interface StudentRecordRepository extends CrudRepository<StudentRecordEntity, Integer>{}
