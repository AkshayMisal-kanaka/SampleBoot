FROM maven:3.8.3-openjdk-17 AS build

COPY pom.xml .
#resolve maven dependencies
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r target/

COPY src ./src
#RUN mvn clean package
RUN mvn clean package  -Dmaven.test.skip
#RUN mvn -f pom.xml clean package

FROM openjdk:17-oracle
VOLUME /tmp
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
#ARG JAR_FILE=target/test-3.0.0.jar
#ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]