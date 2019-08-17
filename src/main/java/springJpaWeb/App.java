package springJpaWeb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				DatabaseConfiguration.class);
	}
}
