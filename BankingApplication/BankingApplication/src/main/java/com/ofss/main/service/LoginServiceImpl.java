package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofss.main.domain.Customer;

import com.ofss.main.repository.LoginCRUDRepo;



@Component
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginCRUDRepo loginCRUDRepo;

	@Override
	public Customer findCustomerByUsername(Customer customer) {
		System.out.println(customer);
	    List<Customer> cl = (List<Customer>) loginCRUDRepo.findAll();
	    for(Customer customerss : cl) {
	    	if(customerss.getLogin_id().equals(customer.getLogin_id()) && 
	    			customerss.getPassword().equals(customer.getPassword())) {
	    		return customerss;
	    	}
	    }
		return null;
	}
	@Override
	public Customer addNewEmployee(Customer customer) {

		return loginCRUDRepo.save(customer);
	}
	
}
