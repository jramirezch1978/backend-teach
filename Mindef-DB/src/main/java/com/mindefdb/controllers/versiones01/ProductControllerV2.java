package com.mindefdb.controllers.versiones01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.examples.ProductDTOV2;
import com.mindefdb.services.IProductService;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {
	@Autowired
	private IProductService productService;
	
	@GetMapping("")
    public List<ProductDTOV2> getProducts() {
        return productService.getAllProductsV2();
    }
}
