FROM openjdk:16-jdk-alpine
USER root
RUN mkdir -p /home/OSAP
COPY oasip-0.0.1.jar /home/OSAP/oasip-0.0.1.jar
RUN chmod -R 777 /home/OSAP/

WORKDIR /home/OSAP
EXPOSE 8080
ENTRYPOINT ["java","-jar","oasip-0.0.1.jar"]