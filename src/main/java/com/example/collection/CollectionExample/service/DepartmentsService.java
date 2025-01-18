package com.example.collection.CollectionExample.service;

import com.example.collection.CollectionExample.model.Employee;

import java.util.*;

public interface DepartmentsService {
    Integer findMinSalaryInDepartment(Integer department);

    Integer findMaxSalaryInDepartment(Integer department);

    List<Employee> findAllEmployeesByDepartment(Integer department);

    Integer countSumSalaryInDepartment(Integer department);

    Double findAverageSumSalaryEmployeesDepartment(Integer department);

    Map<Integer, List<Employee>> listAllEmployeeGroupingByDepartment();

}
