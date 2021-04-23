# X-Men Project

## Description

Given a JSON object which represents a DNA as a nxn matrix like this

	{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

this API determines if that is a DNA of a mutant or a human 

## Requirements 

1. java 8 or higher
2. Maven 
3. git

## Instructions 

To run this program 

1. Clone the repository locally
	
	git clone https://github.com/david347/xmen_project

2. Configure the database connection  in file [application.yaml](https://github.com/david347/xmen_project/blob/e443e4fac9a4798b2950ed6648497785e04cd2fc/org.xmen.devapi/src/main/resources/application.yaml)

		...
		datasource:
			url: jdbc:postgresql://localhost:5435/databaseName
			username: postgres
			password: password
		...



3. Compile using maven or you can run from preffered IDE, the compiled jar will be left on org.xmen.devapi/target folder

	###	`> mvn install`


> Note: the main class is org.xmen.devapi.Application.java

4. Run jar using java command

	###	`> java -jar org.xmen.devapi-0.0.1-spring-boot.jar`
	
> Note: by default the host is http://localhost:8080/

5. Ones the server is ready you can see the documentation in /swagger-ui.html#/DNA, 

	e.i.
	http://localhost:8080/swagger-ui.html#/DNA

Optionally you can use the [postman collection](https://github.com/david347/xmen_project/blob/706c3bf49aa59ea9c3799c64f1e4c21d63e42aee/org.xmen.devapi/X-Men%20API.postman_collection.json) to test the api

## Run tests

You can run test separately for org.xmen.dev and org.xmen.devapi <br>
It uses JUnit and generate reports using jacoco

	> mvn test
	
In the case of the API a MockMvc is used for the tests	
	
### Total coberage
org.meli.dev: 	 98%<br>
org.meli.devapi: 84%

