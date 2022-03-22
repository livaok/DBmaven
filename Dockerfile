FROM maven:3-jdk-11
WORKDIR /workspace/app
COPY src src
COPY pom.xml .
COPY ./dockerApplication/Dockerfile .
RUN mvn package -DskipTests
ENTRYPOINT ["java","-cp","/workspace/app/target/*","Application"]

FROM mysql
WORKDIR /workspace/mysql
EXPOSE 3306
#ENV MYSQL_ROOT_PASSWORD root