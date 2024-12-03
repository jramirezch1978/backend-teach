package com.mindefdb.services.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mindefdb.dtos.UserDTO;
import com.mindefdb.services.IUserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(Long id, UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDTO create(@Valid UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
