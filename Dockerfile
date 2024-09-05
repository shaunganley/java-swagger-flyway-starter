FROM maven:3.9.8 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline

COPY . /app
RUN mvn clean install -DskipTests=true

FROM amazoncorretto:21.0.4
WORKDIR /app
COPY --from=build /app/target/java-dropwizard-flyway-starter-1.0-SNAPSHOT.jar /app/target/
COPY --from=build /app/config.yml /app/
EXPOSE 8080
ARG DB_HOST
ENV DB_HOST=${DB_HOST}
ARG DB_NAME
ENV DB_NAME=${DB_NAME}
ARG DB_USERNAME
ENV DB_USERNAME=${DB_USERNAME}
ARG DB_PASSWORD
ENV DB_PASSWORD=${DB_PASSWORD}
CMD ["java", "-jar", "/app/target/java-dropwizard-flyway-starter-1.0-SNAPSHOT.jar", "server", "/app/config.yml"]
