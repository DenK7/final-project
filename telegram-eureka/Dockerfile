FROM openjdk:11-jre-slim
COPY /target/telegram-eureka.jar /app/app.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
