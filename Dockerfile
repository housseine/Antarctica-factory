FROM openjdk:8
VOLUME /tmp
EXPOSE 8080:8080
ENV APP_ROOT /app
RUN mkdir ${APP_ROOT}
WORKDIR ${APP_ROOT}
RUN ls target
COPY target/antarctica-lab-0.0.1-SNAPSHOT.jar ${APP_ROOT}/antarctica-lab-0.0.1-SNAPSHOT.jar
COPY config ${APP_ROOT}/config/
ENTRYPOINT ["java","-jar","/antarctica-lab-0.0.1-SNAPSHOT.jar"]