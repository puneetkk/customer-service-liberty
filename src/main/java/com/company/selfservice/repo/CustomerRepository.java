package com.company.selfservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.company.selfservice.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
