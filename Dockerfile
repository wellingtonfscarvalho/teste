FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/testePismo-*.jar testePismo.jar
COPY wait-for-it.sh /opt/wait-for-it.sh
WORKDIR /opt
RUN chmod +x wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "-t", "180", "--", "java", "-jar", "/testePismo.jar"]