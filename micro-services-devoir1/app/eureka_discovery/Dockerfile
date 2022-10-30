FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./microservicesApp/discovery.jar
EXPOSE 8761:8761
CMD ["java", "-jar", "./microservicesApp/discovery.jar"]