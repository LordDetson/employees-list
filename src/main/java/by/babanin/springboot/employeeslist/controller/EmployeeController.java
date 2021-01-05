package by.babanin.springboot.employeeslist.controller;

import by.babanin.springboot.employeeslist.model.Employee;
import by.babanin.springboot.employeeslist.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
