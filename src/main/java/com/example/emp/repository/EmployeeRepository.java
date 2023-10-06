package com.example.emp.repository;

import com.example.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
