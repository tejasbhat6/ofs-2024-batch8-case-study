package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;

import com.ofss.main.repository.LoginCRUDRepo;



@Component
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginCRUDRepo loginCRUDRepo;

	@Override
	public String findCustomerByUsername(Customer customer) {
		System.out.println(customer);
	    List<Customer> cl = (List<Customer>) loginCRUDRepo.findAll();
	    for(Customer customerss : cl) {
	    	if(customerss.getLogin_id().equals(customer.getLogin_id()) && 
	    			customerss.getPassword().equals(customer.getPassword())) {
	    			return "true";
	    	}
	    }
		return "false";
	}
	@Override
	public String addNewEmployee(Customer customer) {

		 loginCRUDRepo.save(customer);
		 return "true";
	}
	
}
