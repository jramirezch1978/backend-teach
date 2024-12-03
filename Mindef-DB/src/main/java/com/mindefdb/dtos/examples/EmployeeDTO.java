package com.mindefdb.dtos.examples;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Long departmentId;
}