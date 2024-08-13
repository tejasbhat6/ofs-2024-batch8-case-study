package com.ofss.main.service;

import com.ofss.main.domain.Customer;




public interface LoginService {
		public Customer findCustomerByUsername(Customer customer);
		public Customer addNewEmployee(Customer customer);
}
