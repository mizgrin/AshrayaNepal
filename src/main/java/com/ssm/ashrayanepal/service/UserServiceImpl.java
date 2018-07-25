package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.User;
import com.ssm.ashrayanepal.repository.RoleRepository;
import com.ssm.ashrayanepal.repository.UserRepository;
@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	 BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user){
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
/*		user.setRoles(new Role());
*/		userRepository.save(user);

	

	
	
}

	public User findByUsername(String username) {
		
		return userRepository.findByUserName(username);
	}

	@Override
	public Optional<User> getByid(Long id) {
		return userRepository.findById(id);

	}

	@Override
	public List<User> listuser() {
		return (List<User>) userRepository.findAll();

	}

	}
	
	
	

