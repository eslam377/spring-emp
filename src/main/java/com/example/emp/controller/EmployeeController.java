package com.example.emp.controller;

import com.example.emp.dto.EmployeeDTO;
import com.example.emp.exception.EmployeeNotFoundException;
import com.example.emp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService ;

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(){
        List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();
      	return new ResponseEntity<>(employeeDTOs,HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

}
