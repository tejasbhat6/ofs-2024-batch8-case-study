package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.service.AccountService;
import com.ofss.main.service.LoginService;

@RequestMapping("customercrudapi")
@CrossOrigin("*")
@RestController

public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired AccountService accountService;
	
	@PostMapping("find")
    public String getCustomerByUsername(@RequestBody  Customer customer) {
		System.out.println(customer);
        return loginService.findCustomerByUsername(customer);
    }
	@PostMapping("customers")
	public String addNewEmployeeToDB(@RequestBody  Customer customer) {
		return loginService.addNewEmployee(customer);
	}
	@GetMapping("allaccounts/{id}")
	public List<Account> allAccounts(@PathVariable int id){
		return accountService.lisOfAccount(id);
	}
	@PostMapping("createaccount")
  public String createAccount(@RequestBody Account account) {
	  
	return accountService.createAccount(account);
	  
  }
}
