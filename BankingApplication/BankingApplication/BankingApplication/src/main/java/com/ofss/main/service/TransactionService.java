package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ofss.main.domain.Transaction;
@Service
public interface TransactionService {
	public List<Transaction> listOfTransactions(int account_id);
}
