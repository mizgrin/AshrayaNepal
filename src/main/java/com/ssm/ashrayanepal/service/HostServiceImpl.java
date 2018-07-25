package com.ssm.ashrayanepal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.ashrayanepal.model.HostDetails;
import com.ssm.ashrayanepal.model.User;
import com.ssm.ashrayanepal.repository.HostRepository;
@Service
public class HostServiceImpl implements HostService {
	
	@Autowired
	HostRepository hostRepository;
	
	public void save(HostDetails host) {
		hostRepository.save(host);
		
	}

	public Optional<HostDetails> findByname(String hostName) {
		
		return hostRepository.findByhostName(hostName);
	}

	public Optional<HostDetails> getById(Long Id) {
		return hostRepository.findById(Id);
	}

	@Override
	public List<HostDetails> listhost() {
		return (List<HostDetails>) hostRepository.findAll();
	}

	@Override
	public Optional<HostDetails> getByuser(User user) {
		return hostRepository.findByUserId(user.getUserId());
	}

	/*@Override
	public Optional<HostDetails> getByuser(User user) {
		
		return hostRepository.findById(user);*/
	}

	


	
	
	

