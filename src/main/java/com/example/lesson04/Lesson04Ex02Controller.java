package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {

	@RequestMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@Autowired
	private StudentBO studentBO;
	
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student,  // name(request param)과 일치하는 필드에 값이 들어간다
			Model model) {
		
		// db insert
		studentBO.addStudent(student);
		
		// db select
//		System.out.println("!!!!!" + student.getId());
		Student newStudent = studentBO.getStudentById(student.getId());
		
		// model에 담음
		model.addAttribute("student", newStudent);
		model.addAttribute("subject", "학생정보");
		
		// jsp 경로 리턴
		return "lesson04/afterAddStudent";
	}
}
