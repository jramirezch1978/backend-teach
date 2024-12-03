package com.mindefdb.controllers.nivelesMadurez;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@GetMapping("/{id}")
	public List<Object> getUserAddresses(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
