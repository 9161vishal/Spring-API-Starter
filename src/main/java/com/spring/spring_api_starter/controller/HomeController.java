package com.spring.spring_api_starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/firstpage")
	public String firstPage() {
		return "redirect:/FirstPage.html";
	}
	
	@RequestMapping("/secondpage")
	public String secondPage() {
		return "SecondPage";
	}
	
	@RequestMapping("/template")
	public String templateApi(Model model) {
		model.addAttribute("name", "Vishal Chaudhary");
		return "template1";
	}
}
