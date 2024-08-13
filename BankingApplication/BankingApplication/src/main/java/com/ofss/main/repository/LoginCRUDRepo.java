package com.ofss.main.repository;

import org.springframework.data.repository.CrudRepository;


import com.ofss.main.domain.Customer;

public interface LoginCRUDRepo  extends CrudRepository<Customer, Integer>{


	
}
