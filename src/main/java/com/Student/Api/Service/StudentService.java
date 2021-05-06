package com.Student.Api.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Student.Api.Dao.StudentDao;
import com.Student.Api.domain.Student;


@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentRepo;
	
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getAllStudents(Integer pageNo, Integer pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Student> pagedResult = studentRepo.findAll(paging);
		 if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Student>();
	        }
	}
	
	public int updatePhno(int student_id, long phoneNo) {
		int result =1;
		Student stud = studentRepo.findById(student_id).orElse(new Student());
		
		if(stud.getStudentId() == 0) {
			return result;
		}
		else {
			stud.setPhoneNo(phoneNo);
			studentRepo.save(stud);
			return result = 0;
		}
	}

}
