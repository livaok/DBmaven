FROM maven:3-jdk-11
WORKDIR /workspace/app
COPY src src
COPY pom.xml .
COPY ./dockerApplication/Dockerfile .
RUN mvn -B clean package -DskipTests
ENTRYPOINT ["java","-cp","/workspace/app/target/*","Application"]

#FROM openjdk:11-jdk
#WORKDIR /app
#COPY --from=build /workspace/app/target /app/lib
#ENTRYPOINT ["java","-cp","/app/lib/*","Application"]
#CMD ls /app