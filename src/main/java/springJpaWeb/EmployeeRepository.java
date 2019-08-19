package springJpaWeb;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	Optional<Employee> findByFirstName(String firstName); // how is it possible?
	Optional<Employee> findByLastName(String lastName);

}
