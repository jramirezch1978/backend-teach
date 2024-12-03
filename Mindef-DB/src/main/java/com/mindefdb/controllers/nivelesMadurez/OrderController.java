package com.mindefdb.controllers.nivelesMadurez;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.services.IOrderService;
import com.mindefdb.services.IUserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	//@Autowired
	//private IOrderService orderService;

	@GetMapping("/{userId}/orders")
    public CollectionModel<EntityModel<OrderDTO>> getUserOrders(@PathVariable Long userId) {
        /*
		List<EntityModel<OrderDTO>> orders = orderService.findByUserId(userId).stream()
            .map(order -> EntityModel.of(order,
                linkTo(methodOn(OrderController.class)
                    .getOrder(order.getId())).withSelfRel(),
                linkTo(methodOn(Level3Controller.class)
                    .getUserOrders(userId)).withRel("user-orders")))
            .collect(Collectors.toList());

        return CollectionModel.of(orders,
            linkTo(methodOn(Level3Controller.class)
                .getUserOrders(userId)).withSelfRel(),
            linkTo(methodOn(Level3Controller.class)
                .getUser(userId)).withRel("user"));
       */
		return null;
    }
	

}
