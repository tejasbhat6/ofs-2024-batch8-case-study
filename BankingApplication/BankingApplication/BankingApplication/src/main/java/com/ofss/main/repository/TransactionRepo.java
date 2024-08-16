package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Account;

import com.ofss.main.domain.Transaction;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Integer> {
	public List<Transaction> findByPayeeAccount(Account account);
}
