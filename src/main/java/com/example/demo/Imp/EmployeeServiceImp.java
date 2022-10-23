package com.example.demo.Imp;

import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveUser(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getUsers() {
        return employeeRepository.findAll();
    }


    @Override
    public void deleteUser(Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return employeeRepository.getUserById(id).orElse(new EmployeeDto());
    }

}

