package com.blazdemsar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blazdemsar.domain.Account;
import com.blazdemsar.domain.Role;
import com.blazdemsar.domain.User;
import com.blazdemsar.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="role")
	public String getRoleForm(Role role, Model model) {
		
		model.addAttribute("roles", roleService.findAll());
		
		return "role";
	}
	
	@RequestMapping(value="/saveRole")
	public String saveRole(@ModelAttribute Role role, BindingResult br, Model model) {
		System.out.println("@RoleController.saveRole(...)........ role: "+ role);
		
		if (!br.hasErrors()) {
			
			Role roleFromDb = roleService.createRole(role);
			
		}
		
		model.addAttribute("roles", roleService.findAll());
		
		return "role";
	}
	
//	@RequestMapping(value="deleteRole")
//	public String deleteRole(Role role, @RequestParam Long id, Model model) {
//		System.out.println("@RoleController.deleteRole(...)........ role: "+ role);
//		
//		roleService.deleteById(id);
//		model.addAttribute("roles", roleService.findAll());
//		
//		return "role";
//	}
	
}
