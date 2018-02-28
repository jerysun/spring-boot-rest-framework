# Spring Boot, RESTful API, MySQL, JPA, Hibernate Framework with a compelte unit test

Build Restful APIs using Spring CrudRepository interface for an article classification system.

## Requirements

1. Java SE - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. Spring Boot 1.5.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/jerysun/spring-boot-rest-framework.git
```

**2. Create Mysql database**
```bash
CREATE DATABASE articleDB;
```

More instructions please refer to src/main/resources/articleDB.sql

**3. Change the username and password for the user of this mysql database**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` to your own OR you might as well use mine

**4. Build and run the app using maven**

```bash
mvn clean package
java -jar target/spring-boot-rest-crud-0.0.1-SNAPSHOT.jar
```

Tomcat server will be started. 

Alternatively you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

Tomcat server will be started.

The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following RESTful APIs:

    GET /user/article/{id}

    GET /user/articles
    
    POST /user/article
    
    PUT /user/article
    
    DELETE /user/article/{id}

**5. Run the unit test**

You can use one of the follwoing methods to do it:

Method 1:
To run client unit test, go to the ClientUnitTest class in eclipse and click on Run as -> Java Application. 

Mehtod 2:
You can also test this application using Postman that can be independent from ClientUnitTest.java.

## Learn more

You can find more open source codes written in C, C++, Java, Python, C# by me on my blog "Geeks Small World" -

<https://sites.google.com/site/geekssmallworld/>

Have fun!

Jerry
