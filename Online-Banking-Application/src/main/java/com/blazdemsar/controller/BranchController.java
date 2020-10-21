package com.blazdemsar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blazdemsar.domain.Address;
import com.blazdemsar.domain.Branch;
import com.blazdemsar.service.BranchService;
import com.blazdemsar.validation.BranchValidator;

@Controller
public class BranchController {
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	BranchValidator branchValidator;
	
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.addValidators(branchValidator); }
	 */
	
	@RequestMapping(value="branch")
	public String getBranchForm(Branch branch, Model model) {
		System.out.println("@BranchController.getBranchForm(...)........ branch: "+ branch);
		
		model.addAttribute("branches", branchService.findAll());
		
		return "branch";
	}
	
	@RequestMapping(value="/saveBranch")
	public String saveBranch(@ModelAttribute Branch branch, BindingResult br, Model model) {
		
		System.out.println("@BranchController.saveBranch(...)........ branch: "+ branch);
		
		if (!br.hasErrors()) {
			
			Branch branchFromDb = branchService.save(branch);
			
		}
		
		model.addAttribute("branches", branchService.findAll());
		
		return "branch";
		
	}
	
	@RequestMapping(value="deleteBranch")
	public String deleteBranch(Branch branch, @RequestParam Long id, Model model) {
		
		System.out.println("@BranchController.deleteBranch(...)........ branch: "+ branch);
		
		branchService.deleteById(id);
		model.addAttribute("branches", branchService.findAll());

		return "branch";
	}
	
	@RequestMapping(value="updateBranch")
	public String updateBranch(Branch branch, @RequestParam Long id, Model model) {
		System.out.println("@BranchController.updateBranch(...)........ branch: "+ branch);
		
		Branch b = branchService.findById(id);
		model.addAttribute("branch", b);

		model.addAttribute("branches", branchService.findAll());
		
		return "branch";
	}
	
	@RequestMapping(value="/createBranch")
	public ResponseEntity<Branch> createBranch(@RequestParam String branchName, @RequestParam String addrL1, @RequestParam String addrL2, @RequestParam String city, @RequestParam String state) {
		
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		Address address = new Address(addrL1, addrL2, city, state);
		branch.setBranchAddress(address);
		
		Branch branchFromDb = branchService.save(branch);
		
		return new ResponseEntity<Branch>(branchFromDb, HttpStatus.ACCEPTED);
		
	}
	
//	@RequestMapping(value="/deleteBranch")
//	public ResponseEntity<?> deleteBranch(@RequestParam Long id, Model model) {
//		
//		branchService.deleteById(id);
//
//		Branch branchFromDb = branchService.findById(id);
//		
//		if (branchFromDb != null) {
//			return new ResponseEntity<String>("Branch with id=" + id + " was not deleted.", HttpStatus.ACCEPTED);
//		} else {
//			return new ResponseEntity<String>("Branch with id=" + id + " was deleted successfully.", HttpStatus.ACCEPTED);
//		}
//	}
//	
//	@RequestMapping(value="/updateBranch")
//	public ResponseEntity<?> updateBranch(@RequestParam Long id, @RequestParam String branchName, @RequestParam String addrL1, @RequestParam String addrL2, @RequestParam String city, @RequestParam String state) {
//		
//		Branch branchFromDb = branchService.findById(id);
//		
//		if (branchFromDb != null) {
//			
//			Address address = new Address(addrL1, addrL2, city, state);
//			branchFromDb.setBranchName(branchName);
//			branchFromDb.setBranchAddress(address);
//			
//			Branch branch = branchService.save(branchFromDb);
//			
//			return new ResponseEntity<Branch>(branch, HttpStatus.ACCEPTED);
//			
//		} else {
//			
//			return new ResponseEntity<String>("Branch with id=" + id + " was not found.", HttpStatus.ACCEPTED);
//		
//		}
//	}
	
}
