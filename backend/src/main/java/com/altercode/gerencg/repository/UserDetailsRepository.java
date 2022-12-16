package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);

}
