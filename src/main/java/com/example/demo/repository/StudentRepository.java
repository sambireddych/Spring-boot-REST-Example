package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Long>{
	List<StudentDetails> findByStudentName(String studentName);
	StudentDetails findStudentBysid(String sID);
}
