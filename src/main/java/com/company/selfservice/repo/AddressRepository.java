package com.company.selfservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.company.selfservice.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
