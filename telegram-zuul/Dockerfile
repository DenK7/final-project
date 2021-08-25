FROM openjdk:11-jre-slim
COPY /target/telegram-zuul.jar /app/app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
