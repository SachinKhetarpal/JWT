FROM maven:3.8-openjdk-8-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

FROM openjdk:8
EXPOSE 8080
COPY --from=build /app/target/amarniwas.jar /amarniwas.jar
ENTRYPOINT ["java","-jar","/amarniwas.jar"]
