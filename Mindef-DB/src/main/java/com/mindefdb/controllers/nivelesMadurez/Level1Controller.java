package com.mindefdb.controllers.nivelesMadurez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.UserDTO;
import com.mindefdb.services.IUserService;

@RestController
public class Level1Controller {
	
	@Autowired
	private IUserService userService;
	
    @PostMapping("/api/users/get/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/api/users/create")
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @PostMapping("/api/users/update/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        return userService.update(id, user);
    }

    @PostMapping("/api/users/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
