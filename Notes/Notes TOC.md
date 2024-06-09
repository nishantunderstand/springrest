# Why am I  taking Notes at 2 Place ?
Reason

Notes TOC - Section Specific Question
README - General Question

1. [Notes TOC](/Notes/Notes%20TOC.md)
2. [README](/README.md)


# Section 1 : Introduction
- Step 01 - Microservices and RESTful APIs with Spring Boot and Spring Cloud - Preview
- Step 02 - DO NOT SKIP: Success Stories of Other Learners
- Step 03 - Introduction to the Course & Course Guide
- Step 04 - A surprise! New Course Updates
- Step 05 - DO NOT SKIP: Join in28minutes Learning Community

# Section 2 : Introduction To Web Services
- Step 01 - What is a Web Service?
- Step 02 - Important How Questions related to Web Services
- Step 03 - Web Services - Key Terminology
- Step 04 - Introduction to SOAP Web Services
- Step 05 - Maximizing Learning Efficiency with Playback Speed
- Step 06 - Introduction to RESTful Web Services
- Step 07 - SOAP vs RESTful Web Services
- Step 08 - How to remember things for long time

# Section 3 : Restful Web Services with Spring Boot -V2
- DO NOT SKIP: New to Spring Boot?
- Step 00 - Creating a REST API with Spring Boot - An Overview
- Step 01 - Initializing a REST API Project with Spring Boot
- Step 02 - Creating a Hello World REST API with Spring Boot
- Step 03 - Enhancing the Hello World REST API to return a Bean
	Creating a RestController  
	Controller Vs RestController  
	@SpringBootApplication - Internal Working  
	Declaration is really important.
	
- Step 04 - What's happening in the background? Spring Boot Starters & Autoconfiguration
- Step 05 - Enhancing the Hello World REST API with a Path Variable

	/users/2/todos/200
	Here 2,200 are called path parameters.

	To get the value of Path Parameter we are using Path Variable
	Here we are fetching the value and display in JSON Format.

	@PathVariable - inside method
	Vs 
	@RequestParam - inside method

	https://howtodoinjava.com/spring-mvc/spring-pathvariable-and-requestparam/

	URL Contains Two Types of Request
	1. Path parameters
		@PathVariable  - Spring Framework
	2. Query Parameters
		@RequestParam  - Spring Framework
		@QueryParam - JAX-RS

	https://naveen-metta.medium.com/understanding-requestparam-vs-pathvariable-in-spring-a-comprehensive-guide-41fb956e20f6

- Step 06 - Designing the REST API for Social Media Application
	GET - Retrieve details of a resource
	POST - Create a new resource
	PUT - Update an existing resource
	PATCH - Update part of a resource
	DELETE - Delete a resource

Important Response Statuses
	200 — Success
	201 — Created
	204 — No Content
	401 — Unauthorized (when authorization fails)
	400 — Bad Request (such as validation error)
	404 — Resource Not Found
	500 — Server Error
	
- Step 07 - Creating User Bean and UserDaoService
- Step 08 - Implementing GET Methods for User Resource
- Step 09 - Implementing POST Method to create User Resource
- Step 10 - Enhancing POST Method to return correct HTTP Status Code and Location
- Step 11 - Implementing Exception Handling - 404 Resource Not Found
- Step 12 - Implementing Generic Exception Handling for all Resources
- Step 13 - Implementing DELETE Method to delete a User Resource
- Step 14 - Implementing Validations for REST API
- Step 15 - Overview of Advanced REST API Features
- Step 16 - Understanding Open API Specification and Swagger
- Step 17 - Configuring Auto Generation of Swagger Documentation
- Step 18 - Exploring Content Negotiation - Implementing Support for XML
- Step 19 - Exploring Internationalization for REST API
- Step 20 - Versioning REST API - URI Versioning
- Step 21 - Versioning REST API - Request Param, Header and Content Negotiation
- Step 22 - Implementing HATEOAS for REST API
- Step 23 - Implementing Static Filtering for REST API
- Step 24 - Implementing Dynamic Filtering for REST API
- Step 25 - Monitoring APIs with Spring Boot Actuator
- Step 26 - Exploring APIs with Spring Boot HAL Explorer
- DO NOT SKIP - New to JPA and Hibernate?
- Step 27 - Connecting REST API to H2 using JPA and Hibernate - An Overview
- Step 28 - Creating User Entity and some test data
- Step 29 - Enhancing REST API to connect to H2 using JPA and Hibernate
- Step 30 - Creating Post Entity with Many to One Relationship with User Entity
- Step 31 - Implementing a GET API to retrieve all Posts of a User
- Step 32 - Implementing a POST API to create a Post for a User
- Step 33 - Exploring JPA and Hibernate Queries for REST API
- Step 34 - Connecting REST API to MySQL Database - An Overview
- Step 35 - OPTIONAL - Connecting REST API to MySQL Database - Implementation
- Step 36 - Implementing Basic Authentication with Spring Security
- Step 37 - Enhancing Spring Security Configuration for Basic Authentication