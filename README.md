# Readme: Api Rest Prices Spring boot
Api rest example with spring boot and maven 



## Requirements

The fully fledged server uses the following:

* Spring Framework
* SpringBoot
* H2 databse

## Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

## Building the project
You will need:

*	Java JDK 17 
*	Apache Maven 3.6.3 or higher
*	Git

Clone the project and use Maven to build the server

	$ mvn clean install


## Run

Execute ProductsApplication in the project
	
### Browser API Rest
Open your browser at the following URL with paths and query params

https://localhost:8080/api/

### Browser Database H2
http://localhost:8080/h2-console

### Tests
Run unit test and integration test
```
 mvn test
```
```       
-   Test 1: Get inventory productos
            http://localhost:8080/api/inventory?companyId=1
            
-   Test 2: Get Customer products
            http://localhost:8080/api/products?customerId=1
            
-   Test 3: Get products code
            http://localhost:8080/api/productsCode?companyId=1
            
```
