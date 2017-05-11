FROM openjdk:8-jre
ADD ./build/libs/gifster-0.1.0.jar gifster.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gifster.jar"]