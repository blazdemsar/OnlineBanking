package com.blazdemsar.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AppController {

	@GetMapping(value="accessDeniedPage")
	public String accessDenied() {	   
		return "accessDenied";
	}

	@RequestMapping(value= {"/", "/home"})
	public String getHomePage() {
		System.out.println("@AccountController.getHomePage(...)........ ");

		return "home";
	}

}
