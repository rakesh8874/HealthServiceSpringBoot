package com.healthcorporation.healthservice.service;

import com.healthcorporation.healthservice.domain.Employee;
import com.healthcorporation.healthservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee emp = employeeRepository.findByEmpNumber(employee.getEmpNumber());
        if(emp == null){
            return employeeRepository.save(employee);
        }
        throw new RuntimeException("Details Already Exist");
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }

    @Override
    public Employee getEmployeeByEmpNumber(String empNumber) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        return null;
    }
}
