FROM openjdk:8

VOLUME /tmp

ENV APP_ROOT /Antarctica-factory

RUN mkdir ${APP_ROOT}

WORKDIR ${APP_ROOT}

#RUN echo ${APP_ROOT}

#RUN ls ${APP_ROOT}

#RUN ls -al /Antarctica-factory
RUN ls /target

COPY target/antarctica-lab-0.0.1-SNAPSHOT.jar ${APP_ROOT}/antarctica-lab-0.0.1-SNAPSHOT.jar
COPY config ${APP_ROOT}/config/

ENTRYPOINT ["java","-jar","/antarctica-lab-0.0.1-SNAPSHOT.jar"]