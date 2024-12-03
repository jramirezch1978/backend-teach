package com.mindefdb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindefdb.services.IProductService;

import jakarta.validation.Valid;

import com.mindefdb.dtos.examples.ProductDTO;
import com.mindefdb.dtos.examples.ProductDTOV1;
import com.mindefdb.dtos.examples.ProductDTOV2;
import com.mindefdb.handlers.MethodArgumentNotValidException;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public List<ProductDTOV1> getAllProductsV1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTOV2> getAllProductsV2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO findById(Long id) throws MethodArgumentNotValidException {
		if (id == null) {
			throw new MethodArgumentNotValidException("El ID no debe ser nulo, debe tener un valor, por favor verifique!");
		}
		return null;
	}

	@Override
	public ProductDTO create(@Valid ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<ProductDTO> findBySku(String sku){
		// TODO Auto-generated method stub
		return null;
	}

}

