<<<<<<< HEAD
FROM openjdk:16-jdk-alpine
USER root
RUN mkdir -p /home/OSAP
COPY oasip-0.0.1.jar /home/OSAP/oasip-0.0.1.jar
RUN chmod -R 777 /home/OSAP/

WORKDIR /home/OSAP
EXPOSE 8080
ENTRYPOINT ["java","-jar","oasip-0.0.1.jar"]
=======
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
>>>>>>> 892bdb2afc6fa4e4090e509a78bcf98c6d438f41
