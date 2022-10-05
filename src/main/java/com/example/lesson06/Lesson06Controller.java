package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	
	// AJAX로 요청된 API는 응답값이 ResponseBody로 String으로 내려간다
	@ResponseBody
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd")String yyyymmdd,
			@RequestParam("email")String email,
			@RequestParam(value="introduce", required=false) String introduce
			) {
		
		// TODO: db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		return "success";
	}
	
	@RequestMapping("/get_user_view")
	public String getUerView() {
		return "lesson06/getUser";
	}
	
	
}
