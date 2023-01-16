package com.example.employee.dao;

import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDAO {
    @Autowired
    EntityManager entityManager;

    public Employee findById(int id){
        String sql = "Select e from Employee e where e.id = " + id;
        Employee employee = (Employee) entityManager.createQuery(sql).getSingleResult();
        return employee;
    }

    public List<Employee> getAll() {
        String sql = "Select e from Employee e";
        List<Employee> employees = entityManager.createQuery(sql).getResultList();
        return employees;
    }

    public void save(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(employee);
        txn.commit();
    }

    public void delete(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(employee);
        txn.commit();
    }

    public void edit(Employee employee){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(employee);
        txn.commit();
    }
}
