FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /home/app
COPY . /home/app
ADD ./build/libs/javaDocker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

