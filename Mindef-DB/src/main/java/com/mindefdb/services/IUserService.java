package com.mindefdb.services;

import java.util.List;

import com.mindefdb.dtos.UserDTO;

import jakarta.validation.Valid;

public interface IUserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO updateUser(UserDTO userDTO);

	UserDTO findById(Long id);

	UserDTO update(Long id, UserDTO user);

	void delete(Long id);

	UserDTO create(@Valid UserDTO user);

	List<UserDTO> findAll(int page, int size);

	List<UserDTO> findAll();

}
