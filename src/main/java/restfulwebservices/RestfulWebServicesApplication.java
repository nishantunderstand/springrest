package restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Can a Project have 2 @SpringBootApplication 
 * How this SpringBoot is running the whole Project ?
 * We can name anything we want, No Constaints on that part.
 * Is Spring Based on Servlet ?
 * Should I understand Sevlet as well ? I mean basic 
 */

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
