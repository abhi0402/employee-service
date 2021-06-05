## Employee service

* By default, this project runs on port 8001
* Make sure your cassandra instance has keyspace created with the name **bootcamp**
* If tables do not exist in your cassandra keyspace then it will be created when the code is run for the first time
* By default, this project uses cassandra container running on docker with the name **cassandra-node**. If you are running cassandra locally make sure to change the spring.data.cassandra.contact-points property to **localhost** during runtime
* Have topic with the name **app_updates** created in your kafka cluster before running the app
* The executable jar file can be found in the root path with the name employee-service.jar
* Java 8 should be configured in your system to run the jar file

#### Steps to run the executable jar file are
* Clone the project
* Navigate to the project's root folder
* Run the following command 
```bash
java -jar employee-service.jar
```

### REST Endpoints exposed are:
```bash
POST - http://localhost:{port}/createEmployee
```
```bash
GET - http://localhost:{port}/findEmpSkillset
```