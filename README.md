# ChallengeRFD
Repostitory for RFD challenge.

Please, read the following lines if you want to setup the project in your computer.

VISUALIZE SWAGGER
1. Head to https://editor.swagger.io/.
2. Under File -> Import file, import the JSON swagger file found on this project inside the folder auxData.
3. Now you can visualize the swagger on the right part of the screen.

DATABASE SETUP
1. You will need a local postgres DB to do this. 
2. You can find the DB dump on this project inside the folder auxData/database_dump. Please setup the DB with it.

TEST PROJECT
1. You will need the DESKTOP APP Postman to do this. As you will be running the project in local, Postman web won't work.
2. You can find the Postman's collection on this project inside the folder auxData. Please import it to your Postman.

SETUP PROJECT
1. This project runs on Java 16, with Maven and Spring.
2. Import the project to your favourite IDE (preferably IntelliJ) and run with a configuration of spring-boot:run.
3. The localhost port is 8080.
