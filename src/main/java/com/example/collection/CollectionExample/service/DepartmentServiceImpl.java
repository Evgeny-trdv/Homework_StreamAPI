package com.example.collection.CollectionExample.service;

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
    public Optional<Employee> findMinSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(e -> e.getDepartment().equals(department)).
                min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findMaxSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(e -> e.getDepartment().equals(department)).
                max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Integer countSumSalaryInDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .toList().stream().mapToInt(Employee::getSalary).sum();

    }

    @Override
    public OptionalDouble findAverageSumSalaryEmployeesDepartment(Integer department) {
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .toList().stream().mapToInt(Employee::getSalary).average();
    }

    @Override
    public Map<Integer, List<Employee>> listAllEmployeeByDepartment() {
        return employeeService.findAll().
                stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
