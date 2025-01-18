package com.example.collection.CollectionExample.service;

import com.example.collection.CollectionExample.exception.EmployeeNotFoundException;
import com.example.collection.CollectionExample.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentsService{
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Integer findMinSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToInt(Employee::getSalary)
                .min().orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Integer findMaxSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(e -> e.getDepartment().equals(department))
                .mapToInt(Employee::getSalary)
                .max()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Integer department) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .toList();
    }

    @Override
    public Integer countSumSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .toList().stream().mapToInt(Employee::getSalary).sum();
    }

    @Override
    public Double findAverageSumSalaryEmployeesDepartment(Integer department) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .toList()
                .stream()
                .mapToInt(Employee::getSalary)
                .average()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> listAllEmployeeGroupingByDepartment() {
        return employeeService.findAll()
                        .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
