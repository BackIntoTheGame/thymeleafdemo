package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    // load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        employees = new ArrayList<>();

        Employee empl = new Employee(1, "Leslie", "Andrew", "lesAndre@luv2code.come");
        Employee emp2 = new Employee(1, "emma", "Back", "em@luv2code.come");
        Employee emp3 = new Employee(1, "Avril", "Lav", "avrilLav@luv2code.come");

        employees.add(empl);
        employees.add(emp2);
        employees.add(emp3);
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model model){

        // add to the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
