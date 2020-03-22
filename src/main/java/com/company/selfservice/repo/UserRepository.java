package com.company.selfservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.company.selfservice.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByEmailAndPwd(String email, String pwd);
}
