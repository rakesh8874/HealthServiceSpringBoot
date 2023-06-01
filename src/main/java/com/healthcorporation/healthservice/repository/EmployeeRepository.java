package com.healthcorporation.healthservice.repository;

import com.healthcorporation.healthservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmpNumber(String empNumber);

}
