FROM openjdk:11-jre-slim
COPY /target/telegram-database-caretaker.jar /app/app.jar
EXPOSE 8095
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
