package com.example.collection.CollectionExample;

import com.example.collection.CollectionExample.exception.EmployeeAlreadyAddedException;
import com.example.collection.CollectionExample.exception.EmployeeNotFoundException;
import com.example.collection.CollectionExample.exception.InvalidArgumentException;
import com.example.collection.CollectionExample.model.Employee;
import com.example.collection.CollectionExample.service.EmployeeService;
import com.example.collection.CollectionExample.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class EmployeeServiceTest {

    Employee employeeExpectedFirst = new Employee("Ivan", "Ivanov", 110000, 2);
    Employee employeeExpectedSecond = new Employee("Egor", "Egorov", 100000, 2);
    Collection<Employee> listEmployees = new ArrayList<>(List.of(employeeExpectedFirst, employeeExpectedSecond));

    public final EmployeeService out = new EmployeeServiceImpl();

    @Test
    public void shouldReturnResultOfAddWhenInvalidParams() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> out.add("Ivan", "777Ivanov", 110000, 2));
    }

    @Test
    public void shouldReturnResultOfAddWhenNotArgument() {
        Assertions.assertThrows(RuntimeException.class, () -> out.add("Ivan", null, 110000, 2));
    }

    @Test
    public void shouldReturnResultOfAddWhenEmployeeExists() {
        out.add("Ivan", "Ivanov", 110000, 2);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> out.add("Ivan", "Ivanov", 110000, 2));
    }

    @Test
    public void shouldReturnResultOfAddWhenEmployeeAdded() {
        Assertions.assertEquals(employeeExpectedFirst, out.add("Ivan", "Ivanov", 110000, 2));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenInvalidParams() {
        out.add("Ivan", "Ivanov", 110000, 2);
        Assertions.assertThrows(InvalidArgumentException.class, () -> out.remove("Ivan", "777Ivanov"));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenNotArgument() {
        Assertions.assertThrows(RuntimeException.class, () -> out.remove("Ivan", null));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenEmployeeNotExists() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.remove("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenEmployeeExists() {
        out.add("Ivan", "Ivanov", 110000, 2);
        Assertions.assertEquals(employeeExpectedFirst, out.remove("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnResultOfFindWhenInvalidParams() {
        out.add("Ivan", "Ivanov", 110000, 2);
        Assertions.assertThrows(InvalidArgumentException.class, () -> out.find("Ivan", "777Ivanov"));
    }

    @Test
    public void shouldReturnResultOfFindWhenNotArgument() {
        Assertions.assertThrows(RuntimeException.class, () -> out.find("Ivan", null));
    }

    @Test
    public void shouldReturnResultOfFindWhenEmployeeNotExists() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.find("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnResultOfFindWhenEmployeeExists() {
        out.add("Ivan", "Ivanov", 110000, 2);
        Assertions.assertEquals(employeeExpectedFirst, out.find("Ivan", "Ivanov"));
    }

    @Test
    public void shouldReturnResultOfFindAllEmployees() {
        out.add("Ivan", "Ivanov", 110000, 2);
        out.add("Egor", "Egorov", 100000, 2);
        Assertions.assertIterableEquals(listEmployees, out.findAll());

    }

}
