package by.babanin.springboot.employeeslist.controller;

import by.babanin.springboot.employeeslist.exception.ResourceNotFoundException;
import by.babanin.springboot.employeeslist.model.Employee;
import by.babanin.springboot.employeeslist.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(findById(id));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        Employee employeeToUpdate = findById(id);

        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmailId(employee.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
        return ResponseEntity.ok(updatedEmployee);
    }

    private Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee isn't exist with id " + id));
    }
}
