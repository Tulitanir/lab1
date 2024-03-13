FROM gradle:jdk21-alpine as build
RUN mkdir /tmp/gradle
COPY . /tmp/gradle
WORKDIR /tmp/gradle
RUN gradle build -x test

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /tmp/gradle/build/libs/demo-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]