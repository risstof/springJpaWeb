package springJpaWeb;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableJpaRepositories
public class RunAtStart {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public RunAtStart(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PostConstruct
	private void runAtStart() {

		Employee employee = new Employee();
		Employee employee1 = new Employee();
		employee.setFirstName("Alex");
		employee.setLastname("Kowalski");
		employee1.setFirstName("Arleta");
		employee1.setLastname("Kowal");
		
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		
		Optional<Employee> alexK = employeeRepository.findById(1L);
		System.out.println(alexK);
	}

}
