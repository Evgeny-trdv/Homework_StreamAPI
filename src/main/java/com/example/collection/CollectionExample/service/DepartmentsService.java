package com.example.collection.CollectionExample.service;

import com.example.collection.CollectionExample.model.Employee;

import java.util.*;

public interface DepartmentsService {
    Optional<Employee> findMinSalaryInDepartment(Integer department);

    Optional<Employee> findMaxSalaryInDepartment(Integer department);

    Collection<Employee> findAllEmployeesByDepartment(Integer department);

    Integer countSumSalaryInDepartment(Integer department);

    OptionalDouble findAverageSumSalaryEmployeesDepartment(Integer department);

    Map<Integer, List<Employee>> ListAllEmployeeInDepartment();
}
