FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/testePismo-*.jar testePismo.jar
ENTRYPOINT ["java", "-jar", "/testePismo.jar"]