package hu.bme.aut.spring_rest.repositories;

import hu.bme.aut.spring_rest.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
