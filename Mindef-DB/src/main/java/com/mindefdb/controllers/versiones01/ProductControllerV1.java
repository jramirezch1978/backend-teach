package com.mindefdb.controllers.versiones01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.examples.ProductDTOV1;
import com.mindefdb.services.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerV1 {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping()
    public List<ProductDTOV1> getProducts() {
        return productService.getAllProductsV1();
    }
}
