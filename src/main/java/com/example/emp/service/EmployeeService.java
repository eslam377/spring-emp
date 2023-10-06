package com.example.emp.service;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(long id) throws EmployeeNotFoundException;

}
