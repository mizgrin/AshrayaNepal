package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.Role;
@Service
public interface RoleService{
	public void save(Role role);
	public List<Role>listRole();
	public void delRoleById(Long Id);
	public Optional<Role> getById(Long Id);

}
