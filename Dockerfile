FROM openjdk:17
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 5000

CMD ["java", "-jar", "app.jar"]