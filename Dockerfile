FROM openjdk:8-jdk-alpine
COPY . /var/www/java
WORKDIR /var/www/java
RUN ./gradlew clean build
CMD ["java", "-jar", "build/libs/chatmate-chats-0.0.1-SNAPSHOT.jar"]
