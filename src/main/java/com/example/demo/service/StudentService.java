package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.*;


public interface StudentService {
	List<StudentDetails> findAll();
	StudentDetails save(StudentDetails studentDetails);
	List<StudentDetails> findByStudentName(String studentName);
	Optional<StudentDetails> findById(Long id);
	StudentDetails findBysId(String sID);
	 void delateById(Long id);
}
