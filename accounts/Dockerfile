FROM openjdk:24-ea-17-jdk-slim-bullseye
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts.jar
LABEL version="0.0.1" description="microservice for accounts" maintainer="Sridhar Vadla"
ENTRYPOINT ["java", "-jar", "accounts.jar"]


