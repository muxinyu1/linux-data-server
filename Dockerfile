FROM openjdk:17

WORKDIR /app
COPY . /app

RUN chmod +x mvnw
RUN ./mvnw clean package
RUN cp target/DataServer-0.0.1-SNAPSHOT.jar DataServer-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "DataServer-0.0.1-SNAPSHOT.jar" ]