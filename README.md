# Project people-base
- This is a sample sapring-boot based REST application which shows main crud operations in person entities. 
- More over it is protected by basic authentication supported by spring-security.
- All endpoints are documented with swagger 2.
- It additonally, provides related hateos navigation links for each endpoint response.

## Build
You can build the project with following steps
- Navigate to project root. */people-base/
- Execute a maven build by 'mvn clean package' or 'mvn clean install'
- Find the executable .jar at */people-base/target/
- Alternately you can download the executable .jar file from *******

## Run
- With the executable .jar made with the previous step, you can run the application by 'java -jar people-base-0.0.1-SNAPSHOT.jar' command.
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

## Test with command line client (Curl)
- You can can find sample basic curl commands collection to test this application below. 

## Postman Collection
- You can import the postman collection created for testing purpose from https://www.getpostman.com/collections/3582526d271489102986
    
## Front End client
- A front end client using angular 7 is developed for ease of use. Please find it from https://github.com/hsupunw/people-client

## Alternative Implementation with spring-data-rest
- An alternative implementation with spring-data-rest (fully working with above angular front end) can be found from https://github.com/hsupunw/people-base-data-rest
