FROM maven:3.8.5-openjdk-17

RUN mkdir job4j_fast_food

WORKDIR job4j_fast_food

COPY . .

RUN mvn package -Dmaven.test.skip=true

WORKDIR notification
CMD ["mvn", "liquibase:update"]
CMD ["java", "-jar", "target/notification-1.0-SNAPSHOT.jar"]