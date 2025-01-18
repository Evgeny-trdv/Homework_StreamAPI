package com.example.collection.CollectionExample.controller;

import com.example.collection.CollectionExample.model.Employee;
import com.example.collection.CollectionExample.service.DepartmentsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/{id}/employee/min")
    public Integer findEmployeeWithMinSalaryInDepartment(@PathVariable Integer id) {
        return departmentsService.findMinSalaryInDepartment(id);
    }

    @GetMapping(path = "/{id}/employee/max")
    public Integer findEmployeeWithMaxSalaryInDepartment(@PathVariable Integer id) {
        return departmentsService.findMaxSalaryInDepartment(id);
    }

    @GetMapping(path = "/{id}/employee/sum")
    public Integer countSumSalaryInDepartment(@RequestParam Integer id) {
        return departmentsService.countSumSalaryInDepartment(id);
    }

    @GetMapping(path = "/average")
    public Double findAverageSumSalaryEmployeesDepartment(@RequestParam Integer department) {
        return departmentsService.findAverageSumSalaryEmployeesDepartment(department);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> listAllEmployeeGroupingByDepartment() {
        return departmentsService.listAllEmployeeGroupingByDepartment();
    }
}

