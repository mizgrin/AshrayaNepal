package com.ssm.ashrayanepal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssm.ashrayanepal.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
		Role findByname(String name);
		void deleteById(Long Id);
		void save(Long Id);}
