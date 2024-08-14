package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Customer;

@Service
public interface AccountService {
	public List<Account> lisOfAccount(int customer_id);
	public String createAccount(Account account);
}
