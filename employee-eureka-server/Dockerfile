FROM openjdk:8-jdk-alpine
ADD target/EmployeeEurekaServer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS  -jar /app.jar employeeserver