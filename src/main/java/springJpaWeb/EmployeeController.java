package springJpaWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/greeting")
	public String getTest() {
		System.out.println("Works!");
		return "Works!";
	}
}
