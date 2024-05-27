package restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Can a Project have 2 @SpringBootApplication 
 * No, It will create an ambiguity.
 * 
 * How this SpringBoot is running the whole Project ?
 * We can name anything we want, No Constaints on that part.
 * Is Spring Based on Servlet ?
 * Should I understand Sevlet as well ? I mean basic 
 * 
 * We can name it Anything,
 * Whatever you name, You need to pass that in the SpringApplication.run(FileName.class,args)
 */

@SpringBootApplication
public class RestfulWebServicesApplicationA {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplicationA.class, args);
	}

}
