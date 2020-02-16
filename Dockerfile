FROM openjdk:8
VOLUME /tmp
EXPOSE 8080:8080
ADD target/antarctica-lab-0.0.1-SNAPSHOT.jar antarctica-lab-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/antarctica-lab-0.0.1-SNAPSHOT.jar"]