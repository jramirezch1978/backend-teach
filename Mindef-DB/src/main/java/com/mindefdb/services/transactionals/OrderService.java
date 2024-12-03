package com.mindefdb.services.transactionals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.services.transactionals.entities.Order;


@Service
@Transactional  // A nivel de clase
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	// Hereda la configuración de la clase
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    // Configuración específica
    @Transactional(readOnly = true)
    public Order findById(String nroCompra) throws ResourceNotFoundException {
        return orderRepository.findById(nroCompra)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
}
