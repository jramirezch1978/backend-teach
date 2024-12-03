package com.mindefdb.services;

import java.util.List;
import java.util.Optional;

import com.mindefdb.dtos.examples.ProductDTO;
import com.mindefdb.dtos.examples.ProductDTOV1;
import com.mindefdb.dtos.examples.ProductDTOV2;
import com.mindefdb.handlers.MethodArgumentNotValidException;

import jakarta.validation.Valid;

public interface IProductService {

	List<ProductDTOV1> getAllProductsV1();

	List<ProductDTOV2> getAllProductsV2();

	ProductDTO findById(Long id) throws MethodArgumentNotValidException;

	ProductDTO create(@Valid ProductDTO product);

	void delete(Long id);

	Optional<ProductDTO> findBySku(String sku);

}
