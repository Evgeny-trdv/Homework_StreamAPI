package com.example.collection.CollectionExample.controller;

import com.example.collection.CollectionExample.model.Employee;
import com.example.collection.CollectionExample.service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/find-min")
    public Optional<Employee> findEmployeeWithMinSalaryInDepartment(@RequestParam Integer department) {
        return departmentsService.findMinSalaryInDepartment(department);
    }

    @GetMapping(path = "/find-max")
    public Optional<Employee> findEmployeeWithMaxSalaryInDepartment(@RequestParam Integer department) {
        return departmentsService.findMaxSalaryInDepartment(department);
    }

    @GetMapping(path = "/count-sum")
    public Integer countSumSalaryInDepartment(@RequestParam Integer department) {
        return departmentsService.countSumSalaryInDepartment(department);
    }

    @GetMapping(path = "/average")
    public OptionalDouble findAverageSumSalaryEmployeesDepartment(@RequestParam Integer department) {
        return departmentsService.findAverageSumSalaryEmployeesDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> listAllEmployeeByDepartment(@RequestParam(required = false) Integer department) {
        if (department == null) {
            return departmentsService.listAllEmployeeByDepartment();
        }
        return departmentsService.findAllEmployeesByDepartment(department);
    }
}

