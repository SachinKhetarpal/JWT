FROM maven:3.8.3-openjdk-17 AS build
COPY pom.xml /app/
COPY src /app/src
ENV DBUSER=${MYSQLUSER}
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/amarniwas.jar /amarniwas.jar
ENTRYPOINT ["java","-jar","/amarniwas.jar"]
