FROM amazoncorretto:8
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} redis-cache-msa-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/redis-cache-msa-1.0-SNAPSHOT.jar"]