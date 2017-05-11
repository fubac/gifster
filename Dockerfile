FROM openjdk:8-jre
ADD ./build/libs/gifster-0.1.0.jar gifster.jar
ENTRYPOINT ["java", "-jar", "gifster.jar"]