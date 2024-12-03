package com.mindefdb.services.transactionals;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.services.transactionals.Exceptiones.NotificationException;
import com.mindefdb.services.transactionals.entities.Order;


@Service
@Transactional
public class NotificationService {

	public void sendConfirmation(Order order) throws NotificationException{
		// TODO Auto-generated method stub
		
	}

}
