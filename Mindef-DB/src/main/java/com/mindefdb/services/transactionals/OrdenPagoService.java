package com.mindefdb.services.transactionals;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.services.transactionals.Exceptiones.NotificationException;
import com.mindefdb.services.transactionals.Exceptiones.OrderProcessingException;
import com.mindefdb.services.transactionals.Exceptiones.PaymentException;
import com.mindefdb.services.transactionals.Exceptiones.StockException;
import com.mindefdb.services.transactionals.entities.Order;

@Service
@Transactional
public class OrdenPagoService {
	
	private static Logger log = Logger.getLogger(OrdenPagoService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private InventarioService inventoryService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processOrder(Order order) throws OrderProcessingException {
        try {
            // 1. Guardar orden
            order = orderRepository.save(order);
            
            // 2. Actualizar inventario
            try {
                inventoryService.updateStock(order.getItems());
            } catch (StockException e) {
                throw new OrderProcessingException("No hay stock suficiente");
            }
            
            // 3. Procesar pago
            try {
                paymentService.processPayment(order.getPayment());
            } catch (PaymentException e) {
                throw new OrderProcessingException("Error en el pago");
            }
            
            // 4. Enviar notificación
            try {
                notificationService.sendConfirmation(order);
            } catch (NotificationException e) {
                // Ignoramos error de notificación
                log.error("Error enviando notificación", e);
            }
            
        } catch (OrderProcessingException e) {
            // Cualquier error causará rollback automático
            throw e;
        }
    }
}
