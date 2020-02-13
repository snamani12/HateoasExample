package com.nisum.SpringHateoasExample.service;

import com.nisum.SpringHateoasExample.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public Employee getEmployee(String empId){
        List<Employee> employeeList = getEmployeeList();
        List<Employee> empList = employeeList.stream().filter(emp -> emp.getEmpId().equals(empId)).collect(Collectors.toList());
        return empList.get(0);
    }
    public List<Employee> getEmployeeList(){
        List<Employee> empList = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setEmpId("25");
        emp1.setEmpName("sreeram");
        emp1.setCompany("Nisum");
        empList.add(emp1);

        Employee emp2 = new Employee();
        emp2.setEmpId("26");
        emp2.setEmpName("Laxman");
        emp2.setCompany("Prime");
        empList.add(emp2);

        Employee emp3 = new Employee();
        emp3.setEmpId("27");
        emp3.setEmpName("srikanth");
        emp3.setCompany("Nisum");
        empList.add(emp3);

        return empList;
    }

}
