- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud
- I am going to Study Microservices, With the Help of SpringBoot.

# RestfulWebServicesApplication
- Can a Project have 2 @SpringBootApplication
	No, It will create an ambiguity.

- How this SpringBoot is running the whole Project ?
We can name anything we want, No Constaints on that part.

- Is Spring Based on Servlet ?
- Should I understand Sevlet as well ? I mean basic

- We can name it Anything,Whatever you name, 
	You need to pass that in the SpringApplication.run(FileName.class,args)
 
- Are we creating object of Application Context ?
	Yes, Spring Application is creating this.


# HelloWorldController
Wrong @RequestMapping(method = RequestMethod.GET,path = '/hello-world')
I am not able to understand String.format is the Issue,
' -> Represent Character 
" -> Represent String 
 
- Can we use @Controller instead of @RestController ?

1. Old Approach
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")

2. New Approach
	@GetMapping(path = "/hello-world")


- How to bind the variable that is send from URL.
URL -> Java Application --> Frontend

@GetMapping(path = "/hello-world/path-variable/{name}")
public HelloWorldBean helloworldbeanPathVariableName(@PathVariable String name) {
		