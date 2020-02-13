package com.nisum.SpringHateoasExample.controller;

import com.nisum.SpringHateoasExample.entity.Employee;
import com.nisum.SpringHateoasExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        Employee emp =  employeeService.getEmployee(empId);
        emp.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(empId)).withSelfRel());
        return  emp;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        List<Employee> list =  employeeService.getEmployeeList();
        for (Employee emp: list) {
            emp.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(emp.getEmpId())).withSelfRel());
        }
        return list;
    }

}
