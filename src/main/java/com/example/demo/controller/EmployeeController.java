package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController ///for only crud (rest api)
@Controller   //for using thymeleaf
@RequestMapping("/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("list")
    public String getUsers(Model model) {
        List<Employee> employees = employeeService.getUsers();
        model.addAttribute("employeeList", employees);///this use for controller
        return "index";
    }

    @GetMapping("employee-form")
    public String addUserPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/add_employee";
    }

    @PostMapping("save")
    public String addUser(@ModelAttribute Employee employee,
                          BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "employee/add_employee";
        }

        employeeService.saveUser(employee);
        return "redirect:list";
    }

    @GetMapping("delete/{employeeId}")
    public String deleteUser(@PathVariable("employeeId") Long id) {
        employeeService.deleteUser(id);
        return "redirect:/employee/list";
    }

    @GetMapping("edit/{employeeId}")
    public String editUser(@PathVariable("employeeId") Long id, Model model) {
        EmployeeDto employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee/add_employee";
    }


}
