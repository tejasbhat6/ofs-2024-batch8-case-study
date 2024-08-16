package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Account;
import com.ofss.main.domain.Transaction;
import com.ofss.main.repository.AccountRepo;
import com.ofss.main.repository.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	TransactionRepo transactionRepo;
	@Override
	public List<Transaction> listOfTransactions(int account_id) {
		Optional<Account> optionalaccount = accountRepo.findById(account_id);
		if(optionalaccount.isPresent()) {
			Account account = optionalaccount.get();
			List<Transaction> transactions = transactionRepo.findByPayeeAccount(account);
			System.out.println("List of accounts is: " + transactions);
			return transactions;
 		}
		return null;
	}

}
