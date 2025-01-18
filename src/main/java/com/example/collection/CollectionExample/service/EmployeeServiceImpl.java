package com.example.collection.CollectionExample.service;

import com.example.collection.CollectionExample.exception.EmployeeAlreadyAddedException;
import com.example.collection.CollectionExample.exception.EmployeeNotFoundException;
import com.example.collection.CollectionExample.exception.InvalidArgumentException;
import com.example.collection.CollectionExample.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, Integer salary, Integer department) {
        if (firstName == null || lastName == null || salary == null || department == null) {
            throw new RuntimeException("Один или более параметров отсутствует");
        }
        if (!validateDate(firstName, lastName)) {
            throw new InvalidArgumentException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Один или более параметров отсутствует");
        }
        if (!validateDate(firstName, lastName)) {
            throw new InvalidArgumentException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Один или более параметров отсутствует");
        }
        if (!validateDate(firstName, lastName)) {
            throw new InvalidArgumentException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private boolean validateDate(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }


}
