package com.mindefdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.examples.CompanyDTO;
import com.mindefdb.dtos.examples.DepartmentDTO;
import com.mindefdb.dtos.examples.EmployeeDTO;
import com.mindefdb.services.ICompanyService;

import jakarta.validation.Valid;

//=> http://dominio.com/AplicationName/api/companies

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	@Autowired
    private ICompanyService companyService;
	
	// http://dominio.com/AplicationName/api/companies
	@GetMapping
    public List<CompanyDTO> getAllCompanies() {
        return companyService.findAll();
    }
	
	// http://dominio.com/AplicationName/api/companies/12345
	@GetMapping("/{companyId}")
    public CompanyDTO getCompany(@PathVariable Long companyId) {
        return companyService.findById(companyId);
    }
	
	// http://dominio.com/AplicationName/api/companies/12345/departments

	// Endpoints de segundo nivel - Departments
    @GetMapping("/{companyId}/departments")
    public List<DepartmentDTO> getCompanyDepartments(@PathVariable Long companyId) {
        return companyService.findDepartmentsByCompanyId(companyId);
    }
    
    @PostMapping("/{companyId}/departments")
    public DepartmentDTO createDepartment(
            @PathVariable Long companyId,
            @Valid @RequestBody DepartmentDTO departmentDTO) {
        return companyService.createDepartment(companyId, departmentDTO);
    }
    
    // http://dominio.com/AplicationName/api/companies/12345/departments/453/employees
    
    // Endpoints de tercer nivel - Employees
    @GetMapping("/{companyId}/departments/{departmentId}/employees")
    public List<EmployeeDTO> getDepartmentEmployees(
            @PathVariable Long companyId,
            @PathVariable Long departmentId) {
        return companyService.findEmployeesByDepartmentId(companyId, departmentId);
    }
    
    @PostMapping("/{companyId}/departments/{departmentId}/employees")
    public EmployeeDTO createEmployee(
            @PathVariable Long companyId,
            @PathVariable Long departmentId,
            @Valid @RequestBody EmployeeDTO employeeDTO) {
        return companyService.createEmployee(companyId, departmentId, employeeDTO);
    }
    
    @GetMapping("/{companyId}/departments/{departmentId}/employees/{employeeId}")
    public EmployeeDTO getEmployee(
            @PathVariable Long companyId,
            @PathVariable Long departmentId,
            @PathVariable Long employeeId) {
        return companyService.findEmployeeById(companyId, departmentId, employeeId);
    }


}
