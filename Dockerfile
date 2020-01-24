FROM java:8-jdk-alpine

COPY ./target/spo-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch spo-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","spo-0.0.1-SNAPSHOT.jar"]
