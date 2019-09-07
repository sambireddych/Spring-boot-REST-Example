package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
@Table(name= "studentDetails")
public class StudentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "studentName", nullable = false)
	private String studentName;
	@Column(name="sid", nullable = false, unique = true)
	@NonNull
	@NotEmpty
	private String sid;
	@Column(name = "semester", nullable = false)
	private int semester;
	public StudentDetails(String studentName, String sID, int semester) {
		super();
		this.studentName = studentName;
		this.sid = sID;
		this.semester = semester;
	}
	public StudentDetails() {
		
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	@Override
	public String toString() {
		return "StudentDetails [studentName=" + studentName + ", sID=" + sid + ", semester=" + semester + "]";
	}
	
	

}
