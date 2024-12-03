package com.mindefdb.controllers.versiones03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.examples.ProductDTOV1;
import com.mindefdb.dtos.examples.ProductDTOV2;
import com.mindefdb.services.IProductService;

@RestController
@RequestMapping("/api/products_03")
public class ProductController03 {
    
	@Autowired
	private IProductService productService;
	
	//curl -H "Accept: application/vnd.company.app-v1+json" http://localhost:8080/api/products
    @GetMapping(produces = "application/vnd.company.app-v1+json")
    public List<ProductDTOV1> getProductsV1() {
        return productService.getAllProductsV1();
    }
    
    //curl -H "Accept: application/vnd.company.app-v2+json" http://localhost:8080/api/products
    @GetMapping(produces = "application/vnd.company.app-v2+json")
    public List<ProductDTOV2> getProductsV2() {
        return productService.getAllProductsV2();
    }
}
