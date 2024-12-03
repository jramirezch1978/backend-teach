package com.mindefdb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindefdb.dtos.examples.CompanyDTO;
import com.mindefdb.dtos.examples.DepartmentDTO;
import com.mindefdb.dtos.examples.EmployeeDTO;
import com.mindefdb.services.ICompanyService;

import jakarta.validation.Valid;

@Service
public class CompanyServicesImpl implements ICompanyService {

	@Override
	public List<CompanyDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyDTO findById(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentDTO> findDepartmentsByCompanyId(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentDTO createDepartment(Long companyId, DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> findEmployeesByDepartmentId(Long companyId, Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO createEmployee(Long companyId, Long departmentId, @Valid EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO findEmployeeById(Long companyId, Long departmentId, Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
