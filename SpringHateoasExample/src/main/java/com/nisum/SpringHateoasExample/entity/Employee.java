package com.nisum.SpringHateoasExample.entity;

import org.springframework.hateoas.RepresentationModel;

public class Employee extends RepresentationModel<Employee> {
    private String empId;
    private String empName;
    private String company;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
