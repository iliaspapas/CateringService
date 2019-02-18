package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Forms;
import gr.hua.dit.entity.Student;
import gr.hua.dit.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentApiController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = { "application/json", "application/xml" })
	public void updateStudent(@RequestParam("username") int username,@RequestParam("phone") int phone,@RequestParam("email") String email) {
		
		Student student = studentService.getStudent(username);
		student.setEmail(email);
		student.setPhone(phone);
		studentService.updateStudent(student); //updateStudent
		
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Student getform(@PathVariable("username") int username) {

		Student student = studentService.getStudent(username);
		System.out.println("Student :" + student);

		return student;
	}
	
	
	
}
