Coverage: 33%
# HWA Project

HWA application with user and course entities. The entities link to an SQL and H2 database and has a frontend which users can interact with. The project was tested with JUnit, and was regularly backed up to github.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software

-Eclipse IDE. This software can be installed from the Eclipse website.
-MySQL Workbench. This software can be installed from the MySQL website.
-Visual Studio Code. This software can be installed from the Visual Studio website.
-Postman. This software can be installed from the Postman website.

### Installing

A step by step series of examples that tell you how to get a development env running

1. Create a new Jira board and begin to plan the user stories for the project to prepare. A new git repository for all the code will also have to be made.
2. In a local folder, use GitBash to clone the code URL so the project is now within your local system.
3. Open Eclipse > file > new > Spring Starter Project.
4. Ensure the tools are selected: H2 Database, My SQL driver, Spring data JPA, Spring Web, Validation, Spring Boot dev tools.
5. The folder should show in the package explorer. Begin by making the domain folders and create the entities using @Entitiy.
6. Controller, service and repo packages should then be created for the entities.
7. Open visual studio code and using the static folder that is within the Spring application src/resources, using the static folder to link the HTML pages.
8. Create pages on visual studio code. CSS, JS and HTML pages which will give the website functionality.
10. After the front end is done, use the src/test package back in Eclipse to complete tests for the HWA.
11. Right-click the src/test package to conduct the tests which are there. Coverage As > JUnit Test.
12. A JUnit tab will pop up next to the package explorer. Observe all tests have passed.
13. Right-click src/main then Run as > Spring boo application. Observe the HWA in postman ensuring that the post, get, patch, delete etc are working.
14. Ensure there is functionality and a link between the front end and the backend of the application.

## Running the tests

By right-clicking the src/test package and using coverage as JUnit test, this will test all the code covered within the classes and whether the methods within them have passed. It is important to ensure the tests have passed as this suggests the methods are working and functional. Controller and service classes ehave their own tests, and these can be divided into unit and integration tests.

### Unit Tests 

Testing the methods within the classes allows for detection of whether these tests have passed or failed. If they have failed, it suggests that there is some sort of error in the method code so this would have to be looked at. If there is a test failure here, then it may cause issues in the console when running as an application.

### Integration Tests 
This tests connections and more of the database as opposed to unit tests which only test a function per class. Integration tests look at all modules of the project and how they link. This can be a seperate folder to Unit testing and can be run with its own tests.

## Deployment

Ensuring that this is a Spring boot app so that it can link to both the frontend and the backend database. Testing is done with JUnit, selenium and mockito.

## Built With

Spring boot app.

## Authors

* **Sarah Khan** - *Initial work* - [Sarah Khan](https://github.com/sarahkgh)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*
