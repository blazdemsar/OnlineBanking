package com.blazdemsar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blazdemsar.domain.User;
import com.blazdemsar.service.HibernateUserService;

@RestController
public class UserRestController {

	@Autowired
	@Qualifier(value = "hibernateRoleService")
	HibernateUserService userService;
	
	@RequestMapping(value="allUsers", method=RequestMethod.GET)
	public ResponseEntity<List<User>> allUsers(){

		System.out.println("@UserRestController.allUsers()......");

		List<User> listOfUsers = userService.findAll();

		if (listOfUsers.isEmpty()) {

			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<List<User>>(listOfUsers, HttpStatus.ACCEPTED);

		}

	}
}
