package com.javatechie.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootAzuresqlApplication {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
    	List<Employee> ref=new ArrayList<Employee>();
    	System.out.println(repository.findAll());
    	ref=repository.findAll();
    	for(Employee emp:ref) {
    		System.out.println(emp.toString());
    	}
        return repository.findAll();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAzuresqlApplication.class, args);
    }

}