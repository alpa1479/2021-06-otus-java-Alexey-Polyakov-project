ARG BUILD_HOME=/app

FROM gradle:jdk17-alpine as build-image

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME
WORKDIR $APP_HOME

COPY build.gradle settings.gradle $APP_HOME/
COPY buildSrc $APP_HOME/buildSrc
COPY backend $APP_HOME/backend

RUN gradle --no-daemon build -p ./backend

FROM openjdk:17-alpine

ARG BUILD_HOME
ENV APP_HOME=$BUILD_HOME

COPY --from=build-image $APP_HOME/backend/build/libs/backend.jar backend.jar

ENTRYPOINT java -jar backend.jar