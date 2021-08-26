FROM openjdk:11-jre-slim
COPY /target/telegram-bot.jar /app/app.jar
EXPOSE 8096
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
