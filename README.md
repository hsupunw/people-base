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
- Alternately you can download the executable .jar file from <link>

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
    
## Front End client
- A front end client using angular 7 is developed for ease of use. Please find it from https://github.com/hsupunw/people-client
