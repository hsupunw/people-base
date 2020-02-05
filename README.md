# Project people-base
- This is a sample sapring-boot based REST application which shows main crud operations in person entities. 
- It uses spring-mvc for web layer.
- Also spring-data-jpa for persistence layer with h2 in memory database.
- More over it is protected by basic authentication supported by spring-security.
- All endpoints are documented with swagger 2.
- It additonally, provides related hateoas navigation links for each endpoint response with spring-hateoas.
- Source code is covered by unit and integration tests powered with spring-boot and data-jpa tests.

## Prerequisite
- java 8

## Build
You can build the project with following steps
- Navigate to project root. */people-base/
- Execute a maven build by 
```shell
mvnw clean package
```
or 
```shell
mvnw clean install
```
- Find the executable .jar at */people-base/target/

## Test without installing
- Alternately you can download the executable .jar file directly from https://drive.google.com/open?id=1wv-yCroZx1eoFw-BZML3jAA85LpuL39x

## Run
- With the executable .jar made with the previous step, you can run the application by 
```shell
java -jar people-base-0.0.1-SNAPSHOT.jar
```
command.
- By Default it uses port 8080.

## Api Documentation
- This api is documented with swagger 2 documentation. You can navigate to the swagger-ui with http://localhost:8080/swagger-ui.html

## Authentication 
- This application is secured by basic authentication. So whenever asked please submit following credentials
    - user name: admin
    - password: admin

## H2 Console
- This application uses an in memory h2 db. To navigate to h2 console, go http://localhost:8080/h2-console
    - user name: sa
    - password:

## Command line client (curl)
- Below, you can can find sample basic curl command collection to test this application. 
- Get all
```shell
 curl --user admin:admin localhost:8080/persons
```
- Get one
```shell
 curl --user admin:admin localhost:8080/persons/123
```
- Create
```shell
 curl --user admin:admin -X POST localhost:8080/persons -H 'Content-type:application/json' -d '{
  "age": 54,
  "favourite_colour": "blue",
  "first_name": "Sarah",
  "hobby": [
    "chess"
  ],
  "last_name": "Robinson"
}'
```
- Update
```shell
 curl --user admin:admin -X PUT localhost:8080/persons/123 -H 'Content-type:application/json' -d '{
  "first_name": "John",
  "last_name": "Keynes",
  "age": 29,
  "favourite_colour": "black",
  "hobby": [
    "cricket"
   ]
}'
```
- Delete
```shell
 curl --user admin:admin -X DELETE localhost:8080/persons/123
```

## Postman Collection
- You can import the postman collection created for testing purpose from https://www.getpostman.com/collections/3582526d271489102986
    
## Front End client
- A front end client using angular 7 is developed for ease of use. Please find it from https://github.com/hsupunw/people-client

## Alternative Implementations
- An alternative implementation with spring-data-rest and spring-data-jpa (fully working with above angular front end) can be found from https://github.com/hsupunw/people-base-data-rest
- An alternative implementation with spring-data-rest and spring-data-mongodb (fully working with above angular front end) can be found from https://github.com/hsupunw/people-base-mongo
- An alternative implementation with spring graphQL can be found from https://github.com/hsupunw/people-base-graphql
