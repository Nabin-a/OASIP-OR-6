FROM maven:3.8.5-jdk-11-slim
WORKDIR /app
COPY . .
RUN mvn -Dmaven.test.skip package
CMD mvn spring-boot:run

