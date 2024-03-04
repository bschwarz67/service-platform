# syntax=docker/dockerfile:1

FROM tomcat

COPY ./target/service-platform.war /usr/local/tomcat/webapps/