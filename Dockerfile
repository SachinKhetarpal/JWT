FROM maven:3.8.3-openjdk-17 AS build
ENV DBUSER="${MYSQLPASSWORD}"
ENV DBPASSWORD=${MYSQLPASSWORD}
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/amarniwas.jar /amarniwas.jar
ENTRYPOINT ["java","-jar","/amarniwas.jar"]
