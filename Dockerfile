# ---------- STAGE 1: Build ----------
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# ---------- STAGE 2: Run ----------
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/studentapi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
