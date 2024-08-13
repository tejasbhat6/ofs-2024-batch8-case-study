package com.ofss.main.service;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;




@Service
public interface LoginService {
		public String findCustomerByUsername(Customer customer);
		public String addNewEmployee(Customer customer);
}
