FROM openjdk:11-jre-slim
COPY /target/telegram-config.jar /app/app.jar
EXPOSE 50000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
