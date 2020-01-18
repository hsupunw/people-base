# people-base
This is a sample sapring-boot based REST application which shows main crud operations in person entities. More over it is protected by basic authentication supported by spring-boot.

## build
You can build the project with following steps
- Navigate to project root. */people-base/
- Execute a maven build by 'mvn clean package' or 'mvn clean install'
- Find the executable .jar at */people-base/target/

## run
- With the executable .jar made with the previous step, you can run the application by 'java -jar people-base-0.0.1-SNAPSHOT.jar' command.
- By Default it uses port 8080.
- You can navigate to the swagger-ui with http://localhost:8080/swagger-ui.html
- This application is secured by basic authentication. So whenever asked please submit following credentials
    - user name: admin
    - password: admin
