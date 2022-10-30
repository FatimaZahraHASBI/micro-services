FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./microservicesApp/gateway.jar
EXPOSE 9999:9999
CMD ["java", "-jar", "./microservicesApp/gateway.jar"]