# portfolio-web-app

This is a Java application developed using Spring Boot as framework.

### Setting the application.properties

To build and run the application we need to set some necessary information at application.properties.
You can set these configurations data directly at application.properties, once that you probably will run it locally.
However, you also can set this configuration as environment variables, and invoke its values at application.properties.
You can see below, the kind of data needed:

 ```
spring.datasource.url= set the database url
spring.datasource.username=set the database username
spring.datasource.password=set the database user password
twitter.api.key= set the application key of twiiter api
twitter.api.secret.key=set the application secret of twiiter api
```

There are more configurations in the application.properties file, but they aren't sensible information, so they are set already.
By the way, the credentials of Twitter API were sent via email with the link to this repository.
I needed to use version 2 of Twitter API, and is necessary to use credentials attached to a project.
So I created a project on the Twitter developer web page for this project.

### Running the application

You can run the application using your IDE, but this application has a wrapped mvn, so you don't need to install it to run the application. 

After cloning the project, open a terminal window and reach the application directory as the application below:

```
rodrigos.pereira@MacBook-Pro-de-Rodrigo portfolio-web-app %

```

Let's update the dependencies of the project with the command below. This command will download all project dependencies.

```
 ./mvnw dependency:resolve
```

Now, let's do a build in the project before running it.

```
 ./mvnw install 
```

Finally, we can start the application.

```
./mvnw spring-boot:run
```

The application will start at port 8080, by default. Open your browser and type the following URL ```http://localhost:8080/portfolio/116```.
It will open the portfolio page. The parameter used to find the portfolio is the portfolio's id. In this case, you will bring the portfolio with id number 116, but feel free to try to bring another portfolio.
      
The application has a Swagger documentation that can be viewed at the URL ```http://localhost:8080/swagger-ui/#/```.

### Technologies used

This is a Spring application, so most of the libs used are from this framework.
```
Spring Data to access SQL data.
Spring WebFlux to do requests at Twitter API.
JUnit and Mockito to do unit tests.
Lombok Project to build methods getter, setters, builders, constructors, etc in compilation time.
Swagger Ui and Spring Fox to create REST endpoints documentation.
```
### Development time

Honestly, I didn't count how many hours I spent developing this application. I began to developer it on Saturday and finished it on Wednesday.
So I took the weekend and three days working on it in some periods of the day.
