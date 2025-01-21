FROM openjdk:17-jdk-slim

WORKDIR /app

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENV DB_HOST=db_host_placeholder
ENV DB_PORT=3306
ENV DB_NAME=db_name_placeholder
ENV DB_USERNAME=db_user_placeholder
ENV DB_PASSWORD=db_password_placeholder

ENTRYPOINT ["java", "-jar", "app.jar"]