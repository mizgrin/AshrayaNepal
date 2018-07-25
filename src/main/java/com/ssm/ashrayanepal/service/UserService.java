package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.model.User;
@Service
public interface UserService {
	
	public void save(User user);
	public User findByUsername(String username);
	public Optional<User> getByid(Long id);
	public List<User> listuser();
	
}