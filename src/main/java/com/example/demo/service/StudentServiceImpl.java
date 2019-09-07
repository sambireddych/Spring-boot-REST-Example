package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.*;
import com.example.demo.model.*;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<StudentDetails> findAll() {
		return studentRepository.findAll();
	}

	public StudentDetails save(StudentDetails studentDetails) {
		return studentRepository.saveAndFlush(studentDetails);
	}

	public List<StudentDetails> findByStudentName(String studentName) {
		return studentRepository.findByStudentName(studentName);
	}

	@Override
	public Optional<StudentDetails> findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public StudentDetails findBysId(String sID) {
		return studentRepository.findStudentBysid(sID);
	}

	@Override
	public void delateById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

}
