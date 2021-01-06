package by.babanin.springboot.employeeslist.repository;

import by.babanin.springboot.employeeslist.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
