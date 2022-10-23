package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

  Employee saveUser(Employee user);

  List<Employee> getUsers();

  void deleteUser(Long id);

  EmployeeDto getEmployee(Long id);


}
