FROM openjdk:17-jdk-alpine

WORKDIR /usr/src/app

COPY . .

RUN chmod 700 mvnw && ./mvnw clean install

ENTRYPOINT ["java","-jar","/usr/src/app/target/truthwall-0.0.1-SNAPSHOT.jar"]