package com.mindefdb.dtos.examples;

import lombok.Data;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;
    private String code;
    private Long companyId;
}

