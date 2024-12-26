package com.example.collection.CollectionExample.service;

import com.example.collection.CollectionExample.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer salary, Integer department);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();


}
