package com.example.demo.repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT new  com.example.demo.dto.EmployeeDto(u) "
			+ "FROM Employee u WHERE u.id = ?1")
	Optional<EmployeeDto> getUserById(Long id);
	
	
	
	
	
	
}
