# Build Stage
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /demo

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jre

WORKDIR /demo

COPY --from=builder /demo/target/*.jar demo.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","demo.jar"]