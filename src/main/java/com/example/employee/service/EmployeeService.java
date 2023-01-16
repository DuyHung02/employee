package com.example.employee.service;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public void delete(int id) {
        employeeDAO.delete(employeeDAO.findById(id));
    }

    public void edit(Employee employee) {
        employeeDAO.edit(employee);
    }

    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }
}
