package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		// list<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("멜론");
		fruits.add("복숭아");
		fruits.add("포도");
		fruits.add("망고");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "이재현");
		map.put("age", 99);
		map.put("hobby", "잠");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name", "솔");
		map.put("age", 1000);
		map.put("hobby", "고릴라");
		users.add(map);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@RequestMapping("/ex03")
	public String ex03(Model model) {
		Date now = new Date();
		model.addAttribute("today",now);
		return "lesson05/ex03";
	}
	
	@RequestMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
}
