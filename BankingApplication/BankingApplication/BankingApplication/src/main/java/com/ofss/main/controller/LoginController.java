package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;

import com.ofss.main.service.LoginService;

@RequestMapping("customercrudapi")
@CrossOrigin("*")
@RestController

public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("find")
    public String getCustomerByUsername(@RequestBody  Customer customer) {
		System.out.println(customer);
        return loginService.findCustomerByUsername(customer);
    }
	@PostMapping("customers")
	public String addNewEmployeeToDB(@RequestBody  Customer customer) {
		return loginService.addNewEmployee(customer);
	}
}
