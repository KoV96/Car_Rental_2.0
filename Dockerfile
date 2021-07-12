FROM openjdk:8
ADD target/car-rental.jar car-rental.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "car-rental.jar"]