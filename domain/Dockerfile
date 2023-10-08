FROM maven:3.8.5-openjdk-17

RUN mkdir job4j_fast_food

WORKDIR job4j_fast_food

COPY . .

WORKDIR domain

RUN mvn package