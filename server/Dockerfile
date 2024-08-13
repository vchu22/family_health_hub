# Copy the .env file to src/main/resources/env.properties
COPY .env /home/gradle/src/main/resources/env.properties

#
# Build stage
#
FROM gradle:jdk17-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

LABEL org.name="io.github.vchu22"
#
# Package stage
#
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/family_and_pets_health_tracker-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]