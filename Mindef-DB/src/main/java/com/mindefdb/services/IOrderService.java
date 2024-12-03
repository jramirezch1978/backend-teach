package com.mindefdb.services;

import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.EntityModel;

import com.mindefdb.controllers.nivelesMadurez.OrderDTO;

public interface IOrderService {

	List<EntityModel<OrderDTO>> findByUserId(Long userId);

}
