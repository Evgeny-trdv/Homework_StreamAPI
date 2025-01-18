package com.example.collection.CollectionExample;

import com.example.collection.CollectionExample.exception.EmployeeNotFoundException;
import com.example.collection.CollectionExample.model.Employee;
import com.example.collection.CollectionExample.service.DepartmentServiceImpl;
import com.example.collection.CollectionExample.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void unit() {
        when(employeeService.findAll())
                .thenReturn(List.of(
                        new Employee("Ivan", "Ivanov", 110000, 2),
                        new Employee("Egor", "Egorov", 100000, 2),
                        new Employee("Viktor", "Brown", 94000, 2),
                        new Employee("Elena", "White", 105000, 1),
                        new Employee("Maria", "Green", 145000, 1)
                ));
    }

    @Test
    public void shouldReturnMinSalaryInDepartment() {
        Assertions.assertEquals(94000, out.findMinSalaryInDepartment(2));
    }

    @Test
    public void shouldReturnMinSalaryInDepartmentIfDepartmentIsEmpty() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findMinSalaryInDepartment(3));
    }

    @Test
    public void shouldReturnMaxSalaryInDepartment() {
        Assertions.assertEquals(110000, out.findMaxSalaryInDepartment(1));
    }

    @Test
    public void shouldReturnMaxSalaryInDepartmentIfDepartmentIsEmpty() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findMaxSalaryInDepartment(3));
    }

    @Test
    public void shouldReturnSumAllSalariesInDepartment() {
        Assertions.assertEquals(250000, out.countSumSalaryInDepartment(1));
    }

    @Test
    public void shouldReturnSumAllSalariesInDepartmentIfDepartmentIsEmpty() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findMaxSalaryInDepartment(3));
    }

    @Test
    public void shouldReturnAverageSalaryInDepartment() {
        Assertions.assertEquals(125000.0, out.findAverageSumSalaryEmployeesDepartment(1));
    }

    @Test
    public void shouldReturnAverageSalaryInDepartmentIfDepartmentIsEmpty() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findAverageSumSalaryEmployeesDepartment(3));
    }

    @Test
    public void shouldReturnAllEmployeesInDepartment() {
        List<Employee> employeesExpected = new ArrayList<>(List.of(
                new Employee("Ivan", "Ivanov", 110000, 2),
                new Employee("Egor", "Egorov", 100000, 2),
                new Employee("Viktor", "Brown", 94000, 2)
        ));
        Assertions.assertEquals(employeesExpected, out.findAllEmployeesByDepartment(2));
    }

    @Test
    public void shouldReturnMapAllEmployeeGroupingByDepartment() {
        Map<Integer, List<Employee>> employeeGroupingByDepartmentExpected = Map.of(
                1, new ArrayList<>(List.of(
                        new Employee("Elena", "White", 105000, 1),
                        new Employee("Maria", "Green", 145000, 1))),
                2, new ArrayList<>(List.of(
                        new Employee("Ivan", "Ivanov", 110000, 2),
                        new Employee("Egor", "Egorov", 100000, 2),
                        new Employee("Viktor", "Brown", 94000, 2))));

        Assertions.assertEquals(employeeGroupingByDepartmentExpected, out.listAllEmployeeGroupingByDepartment());
    }
}
