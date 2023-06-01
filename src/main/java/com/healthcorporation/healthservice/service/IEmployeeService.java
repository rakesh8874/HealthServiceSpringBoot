package com.healthcorporation.healthservice.service;

import com.healthcorporation.healthservice.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    boolean deleteEmployee(int id);

    Employee  getEmployeeByEmpNumber(String empNumber);

    Employee updateEmployee(Employee employee, int id);

}
