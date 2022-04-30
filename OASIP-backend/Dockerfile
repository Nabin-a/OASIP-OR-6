FROM maven:3.8.2-jdk-8
WORKDIR usr/src/app
COPY /src usr/src/app
RUN mvn clean install
CMD mvn spring-boot:run