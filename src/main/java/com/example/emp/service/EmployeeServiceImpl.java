package com.example.emp.service;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.entity.Employee;
import com.example.emp.exception.EmployeeNotFoundException;
import com.example.emp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository ;

    private final ModelMapper modelMapper ;


    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());

        return employeeDTOs;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("employee not found with id " + id);
        }
        EmployeeDTO employeeDTO =  modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }


}
