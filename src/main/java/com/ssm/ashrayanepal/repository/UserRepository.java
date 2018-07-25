package com.ssm.ashrayanepal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
		User findByUserName(String userName);
		void save(Long Id);
}
