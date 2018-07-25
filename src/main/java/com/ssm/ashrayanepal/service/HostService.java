package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.model.User;

@Service
public interface HostService {
	public void save(HostDetails host) ;
	public Optional<HostDetails> findByname(String name);
	public Optional<HostDetails> getById(Long Id);
	public List<HostDetails>listhost();
	public Optional<HostDetails> getByuser(User user);
}
