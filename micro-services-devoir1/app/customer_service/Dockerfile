FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./microservicesApp/customer.jar
EXPOSE 8082:8082
CMD ["java", "-jar", "./microservicesApp/customer.jar"]