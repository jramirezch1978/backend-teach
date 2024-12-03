package com.mindefdb.services.impl;

import java.util.List;

import org.springframework.hateoas.EntityModel;

import com.mindefdb.controllers.nivelesMadurez.OrderDTO;
import com.mindefdb.services.IOrderService;

public class OrderServiceImpl implements IOrderService{

	@Override
	public List<EntityModel<OrderDTO>> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
