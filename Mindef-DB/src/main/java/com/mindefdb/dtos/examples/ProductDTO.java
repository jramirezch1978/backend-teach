package com.mindefdb.dtos.examples;

import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;  // Campo nuevo en V2
    private List<String> tags;   // Campo nuevo en V2
}

