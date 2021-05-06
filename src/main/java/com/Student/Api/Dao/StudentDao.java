package com.Student.Api.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.Api.domain.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	

}
