FROM openjdk:8
EXPOSE 8080
ADD target/sachin-test-name.jar sachin-test-name.jar
ENTRYPOINT ["java","-jar","/amarniwas.jar"]
