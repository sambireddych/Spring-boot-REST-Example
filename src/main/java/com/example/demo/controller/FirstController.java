package com.example.demo.controller;

import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentDetails;
import com.example.demo.service.StudentService;

@RestController
public class FirstController {

	private StudentService studentService;

	public FirstController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
	public String home() {
		return "<html><h1>Rest API Demo using Java</h1></html>";
	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, value = { "/students" })
	public @ResponseBody List<StudentDetails> getAll() {
		return studentService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" }, value = { "/student/create" })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveOrUpdate(@RequestBody StudentDetails studentDetails) throws Exception {
		String sid = studentDetails.getSid();
		StudentDetails exist = studentService.findBysId(sid);
		System.out.println("student id>>>>>>>>>>>> : "+exist);
		if(exist!=null) {
			return new ResponseEntity<ErrorAttributes>(HttpStatus.FORBIDDEN);
		}
		StudentDetails sd = studentService.save(studentDetails);
		return new ResponseEntity<StudentDetails>(sd, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, value = { "students/{sid}" })
	public ResponseEntity<StudentDetails> getStudentBySid(@PathVariable("sid") String sID) {
		StudentDetails sd = studentService.findBysId(sID);
		if(sd == null) {
			return new ResponseEntity<StudentDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudentDetails>(sd, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { "application/json" }, produces = {
			"application/json" }, value = { "student/{id}" })
	public ResponseEntity<?> updateDetails(@RequestBody StudentDetails studentDetails, @PathVariable("id") Long id)
			throws Exception {
		StudentDetails sd = studentService.findById(id).orElseThrow(() -> new Exception("Not found"));
		sd.setStudentName(studentDetails.getStudentName());
		sd.setSid(studentDetails.getSid());
		sd.setSemester(studentDetails.getSemester());
		StudentDetails sd1 = studentService.save(sd);
		return new ResponseEntity<StudentDetails>(sd1, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, value = { "student/{studentName}" })
	public ResponseEntity<List<StudentDetails>> getStudentByName(@PathVariable("studentName") String studentName) {
		List<StudentDetails> sd = studentService.findByStudentName(studentName);
		return new ResponseEntity<List<StudentDetails>>(sd, HttpStatus.OK);

	}
	@RequestMapping(method = RequestMethod.DELETE, produces = { "application/json" }, value = { "student/{id}" })
	public void delate(@PathVariable("id") Long id) {
		studentService.delateById(id);
	}
	

}
