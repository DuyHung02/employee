package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityTransaction;

@Controller
public class Home {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "/create";
    }

    @PostMapping("/create")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Employee employee) {
        employeeService.edit(employee);
        return "redirect:/home";
    }
}
