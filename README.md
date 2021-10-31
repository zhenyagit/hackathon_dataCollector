# data_collector

This project collects data from a crypto exchange "dydx".
Indicators such as:
- volume of sales
- volume of purchases
- average price
-
The application collects data on all currencies on the exchange every 10 seconds throughout the day.
Every day the data is averaged, the average price is found and saved to the database, the data for the day is deleted


## Dependencies
- Docker or JVM
- mvn to build

## How to use
**First run MySQL db, then run this project **
First create docker network:
```sh 
sudo docker network create hackathon_project
```
Then run db and connet it to network:
```sh 
sudo docker run -d -it -p 3306:3306 --network hackathon_project -e MYSQL_ROOT_PASSWORD=xxx -e MYSQL_DATABASE=calculator_sure_db --name calculator_sure_app mysql
```
clone repo:
```sh 
git clone https://github.com/zhenyagit/hackathon_dataCollector
```

In root directory build project:
```sh
mvn package -Dmaven.test.skip
```

(If you use JVM):
go to /target and run:
```sh
java -jar hackathon_dataCollector-x.x.x-SNAPSHOT.jar
```
where "x.x.x" is the application version

(If you use Docker):
- Create folder to build docker container
- Create file with name "Dokerfile"
- Paste this into Dockerfile:
```sh
FROM openjdk:8-jdk-alpine
CMD ["mkdir", "app"]
WORKDIR app/
ARG JAR_FILE
COPY ${JAR_FILE} app/app.jar
ENTRYPOINT ["java","-jar","app/app.jar"]
```
To build:
```sh
sudo docker build --build-arg JAR_FILE=/path/to/App.jar -t your_nickname/data_collector .
```
To run:
```sh
 sudo docker run -d -it -p 8080:8080 --network  hackathon_project --name data_collector your_nickname/data_collector
```
"hackathon_project" - docker network with MySQL db


