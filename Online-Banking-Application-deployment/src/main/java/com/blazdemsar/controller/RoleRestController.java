package com.blazdemsar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blazdemsar.domain.Role;
import com.blazdemsar.service.RoleService;

@RestController
public class RoleRestController {

	@Autowired
	@Qualifier(value = "hibernateRoleService")
	RoleService roleService;
	
	@RequestMapping(value="allRoles", method=RequestMethod.GET)
	public ResponseEntity<List<Role>> allRoles(){

		System.out.println("@RoleRestController.allRoles()......");

		List<Role> listOfRoles = roleService.findAll();

		if (listOfRoles.isEmpty()) {

			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<List<Role>>(listOfRoles, HttpStatus.ACCEPTED);

		}

	}
}
