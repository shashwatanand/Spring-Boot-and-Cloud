package com.shashwat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shashwat.model.Person;

@Controller
public class PersonController {
	
	@RequestMapping("/person")
	public String person(Model model) {
		Person person = new Person();
		person.setFirstName("Shashwat");
		person.setLastName("Anand");
		person.setAge(32);
		model.addAttribute("person", person);
		return "personview";
	}
	
	@ResponseBody
	@RequestMapping("/")
	public String index() {
		return "Spring boot Thymeleaf app";
	}
}
