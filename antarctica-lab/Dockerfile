FROM openjdk:8

VOLUME /tmp

RUN ls home
run echo ${TRAVIS_BUILD_DIR}
run echo $TRAVIS_BUILD_DIR

ADD antarctica-lab/target/antarctica-lab-0.0.1-SNAPSHOT-antarctica.jar antarctica-lab-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/antarctica-lab-0.0.1-SNAPSHOT.jar"]