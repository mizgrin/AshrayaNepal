package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.Role;
import com.ssm.ashrayanepal.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	
			
	

	public List<Role> listRole() {

		return roleRepository.findAll();
	}

	public void delRoleById(Long Id) {
		roleRepository.deleteById(Id);
	}

	public void save(Role role) {
		roleRepository.save(role);
	}

	public Optional<Role> getById(Long Id) {
		return roleRepository.findById(Id)	;
	}
	
	
	
}
