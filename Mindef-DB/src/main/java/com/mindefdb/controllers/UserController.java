package com.mindefdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.UserDTO;
import com.mindefdb.dtos.validationGroup.OnCreate;
import com.mindefdb.dtos.validationGroup.OnUpdate;
import com.mindefdb.services.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
    
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Validated(OnCreate.class) @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
            								  @Validated(OnUpdate.class) @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }
}
