#
# Build stage
#
FROM maven:4.0.0-jdk-19-slim AS build
COPY src /service-platform/src/
COPY pom.xml /service-platform
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:19-jre-slim
COPY --from=build /service-platform/target/service-platform.war /usr/local/lib/demo.war
EXPOSE 8080
ENTRYPOINT ["java","-war","/usr/local/lib/demo.war"]