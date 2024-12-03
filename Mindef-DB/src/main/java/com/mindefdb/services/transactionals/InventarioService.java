package com.mindefdb.services.transactionals;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.services.transactionals.Exceptiones.StockException;
import com.mindefdb.services.transactionals.entities.OrderDetail;

@Service
@Transactional
public class InventarioService {

	public void updateStock(List<OrderDetail> items) throws StockException{
		// TODO Auto-generated method stub
		
	}

}
