FROM openjdk:8

VOLUME /tmp

RUN ls home
run echo ${TRAVIS_BUILD_DIR}
run echo $TRAVIS_BUILD_DIR

ADD target/clothes-0.0.1-SNAPSHOT-clothes.jar clothes-0.0.1-SNAPSHOT-clothes.jar
ENTRYPOINT ["java","-jar","/clothes-0.0.1-SNAPSHOT-clothes.jar"]