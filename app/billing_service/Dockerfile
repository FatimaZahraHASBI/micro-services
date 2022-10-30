FROM openjdk:17-alpine
COPY ./build/libs/*.jar ./microservicesApp/billing.jar
EXPOSE 8083:8083
CMD ["java", "-jar", "./microservicesApp/billing.jar"]