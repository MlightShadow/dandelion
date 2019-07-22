FROM java:8-jdk
WORKDIR /dandelion
ENTRYPOINT ["java" ,"-jar","/dandelion/dandelion.jar"]