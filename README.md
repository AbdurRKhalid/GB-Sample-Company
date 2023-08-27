## 📄 Introduction
This project contains code for the implementation of Greenbone AG programming task. This project is a Rest API built using Spring Boot. This project has main functionality of Adding, Updating, Searching and Deleting the computers stored in a PSQL Database.
## 🛠️ Setting up the Enviornment
1. It has been supposed that Java and Maven have already been installed and configured in the system. (current project uses Java 17)
2. This project works with PostgreSQL database to store the data. Docker provides a convinent way to set-up all the services, so a **docker-compose.yml** file has been added. Now, if the following command is run:
`docker compose up`
It will install and run the **PostgreSQL** database on port **5432** and it will also install the **pgadmin** and run it on the port **5050**. The password to login, can be found in docker-compose.yml file.

## 🔨 Installing the Maven Dependencies
This Spring Boot project is a Maven project, which means that there is a need to install all the dependencies mentioned in the `pom.xml` file. This can be done with the following command:
`mvn dependency:resolve`

## 🏗️ Building the Project
Before running the project it is a conventional practice to build the project and with Macen it can be done with the following command, this command will generate a `jar` file that can be run with simple Java.
`mvn clean`

## 🚀 Running the Project
Now there are two ways to run this project,
1. With Java.
2. With Maven.

As we have Maven installed so we can use the following command to run the project:
`mvn spring-boot:run`
The above command will start the server on port **9090**.

## 🧪 Running the Tests
Some basic tests has been added (with Mockito and JUnit) and the Tests can be run with the following command:
`mvn test`

## 🔗 API End Points
The base URL is http://localhost:9090/computers.
The following is the explanation of each end-point:
| No | End Point                           | Request Method | Explanation                                                                                                                                                                                                                                     |
|----|-------------------------------------|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | /add                                | POST           | This API end-point will accept the JSON data and will add a new computer record to the database,  but if an employee have 3 or more than 3 computers assigned already then a notification request will be sent to service running on port 8080. |
| 2  | /get-all                            | GET            | This API end-point will return all the records of the Computers in DB.                                                                                                                                                                          |
| 3  | /get-all-by-employee/{abbreviation} | GET            | This API end-point will return all the records associated with an Employee Abbreviation.                                                                                                                                                        |
| 4  | /get-by-id/{id}                     | GET            | This API end-point will return a single Computer Record based on given id.                                                                                                                                                                      |
| 5  | /delete-by-id/{id}                  | DELETE         | This API end-point will delete a single Computer Record from Database of given id.                                                                                                                                                              |
| 6  | /reassign/{id}/{abbreviation}       | GET            | This API end-point will assign the Computer Record having a specific id to an employee with given Abbreviation.                                                                                                                                 |
| 7  | /update-computer                    | PUT            | This API end-point will update the provided updated Computer Record.                                                                                                                                                                            |

*For the /add end-point it is important that the Notification-service is running on port 8080

## 📝 Notes
1. It would be appropriate if the _employee abbreviation_ property would be mandatory.
2. If I had to add something extra I would like to add GitHub actions for the purpose of Continous Integration.