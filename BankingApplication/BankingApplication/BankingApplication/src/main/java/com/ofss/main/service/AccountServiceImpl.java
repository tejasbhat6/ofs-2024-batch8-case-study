package com.ofss.main.service;

import java.lang.StackWalker.Option;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.repository.LoginCRUDRepo;
@Service

public class AccountServiceImpl implements AccountService{
	@Autowired 
	LoginCRUDRepo loginCRUDRepo;
	@Autowired
	AccountRepo accountRepo;
	
	
	@Override
	public List<Account> lisOfAccount(int customer_id) {
		Optional<Customer> optionalcustomer = loginCRUDRepo.findById(customer_id);
		if(optionalcustomer.isPresent()) {
			Customer customer = optionalcustomer.get();
			List<Account> accounts = accountRepo.findByCustomer(customer);
			System.out.println("List of accounts is: " + accounts);
			return accounts;
 		}
		return null;
	}


	@Override
	public String createAccount(Account account) {
		Optional<Customer> optionalcustomer = loginCRUDRepo.findById(account.getCustomer().getId());
		Customer customer = optionalcustomer.get();
		System.out.println(customer);
		account.setCustomer(customer);
		accountRepo.save(account);
		return "true";
		
		
 		
	}
	

}
