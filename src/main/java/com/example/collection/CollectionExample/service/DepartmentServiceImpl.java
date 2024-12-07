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
    public Optional<Employee> findMinSalaryInDepartment(Integer department) {        //метод поиска минимальной зп в определенном отделе
        return employeeService.findAll()
                .stream().filter(e -> e.getDepartment().equals(department)).
                min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findMaxSalaryInDepartment(Integer department) {        //метод поиска max зп в определенном отделе
        return employeeService.findAll()
                .stream().filter(e -> e.getDepartment().equals(department)).
                max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartment(Integer department) {  //поиск всех сотрудников из одного отдела
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Integer countSumSalaryInDepartment(Integer department) {     //Метод подсчета суммы затрат на зарплаты работникам в отделе
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .toList().stream().mapToInt(Employee::getSalary).sum();

    }

    @Override
    public OptionalDouble findAverageSumSalaryEmployeesDepartment(Integer department) {     //средняя зп работников в отделе
        return employeeService.findAll()
                .stream().filter(employee -> employee.getDepartment().equals(department))
                .toList().stream().mapToInt(Employee::getSalary).average();
    }

    @Override
    public Map<Integer, List<Employee>> listAllEmployeeByDepartment() { //
        return employeeService.findAll().
                stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
