package com.blazdemsar.controller;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blazdemsar.domain.Role;
import com.blazdemsar.domain.User;
import com.blazdemsar.service.MailService;
import com.blazdemsar.service.RoleService;
import com.blazdemsar.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	MailService mailService;

	@RequestMapping(value = "createUser", method = RequestMethod.GET)
	public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam String password,
			@RequestParam String email) {

		User user = new User(name, password, email);
		List<Role> rolesFromDb = roleService.findAll();

		Set<Role> roles = new HashSet<>();

		roles.add(rolesFromDb.get(2));
		roles.add(rolesFromDb.get(3));

		user.setRoles(roles);

		User userFromDb = userService.createUser(user);

		return new ResponseEntity<User>(userFromDb, HttpStatus.CREATED);
	}

	@RequestMapping(value="user")
	public String userForm(User user, Model model) {
		List<Role> roleList = roleService.findAll();
		Set<Role> roleSet = new LinkedHashSet<>(roleList);
		user.setRoles(roleSet);

		model.addAttribute("roleSet", roleSet);
		model.addAttribute("users", userService.findAll());
		return "user";
	}

	@PostMapping("saveUser")
	public String saveUser(@Valid @ModelAttribute User user, BindingResult br, Model model) {
		System.out.println("@UserController.saveUser()....user: " + user);
		System.out.println("@UserController.saveUser()....roles: " + user.getRoles().toString());

		if (!br.hasErrors()) {
			userService.createUser(user);
			
			SimpleMailMessage message = mailService.sendEmail(user.getName(), user.getEmail());
		}

		List<Role> roleList = roleService.findAll();
		Set<Role> roleSet = new LinkedHashSet<>(roleList);
		user.setRoles(roleSet);
		model.addAttribute("roleSet", roleSet);
		model.addAttribute("users", userService.findAll());

		return "user";
	}

	@GetMapping(value = "updateUser")
	public String updateUser(User user, @RequestParam Long userId, Model model) {
		List<Role> roleList = roleService.findAll();
		Set<Role> roleSet = new LinkedHashSet<>(roleList);
		model.addAttribute("roleSet", roleSet);

		if (userService.existsById(userId)) {
			user = userService.findById(userId);
			model.addAttribute("user", user);
			Set<Role> selectedRoles = user.getRoles();
			model.addAttribute("selectedRoles", selectedRoles);
		} else {
			model.addAttribute("user", new User());
		}

		model.addAttribute("users", userService.findAll());

		return "user";
	}
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(User user, @RequestParam Long id, Model model) {
		System.out.println("@UserController.deleteUser(...)........ user: "+ user);
		
		userService.deleteById(id);
		model.addAttribute("users", userService.findAll());
		
		return "user";
	}
}
