package com.example.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Controller {

	@RequestMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd")String yyyymmdd,
			@RequestParam("email")String email,
			@RequestParam(value="introduce", required=false) String introduce
			) {
		return "lesson06/";
		
	}
	
	
	
}
