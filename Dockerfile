FROM openjdk:11

ADD target/school-management-0.0.1-SNAPSHOT.jar school-management.jar

ENTRYPOINT ["java","-jar","school-management.jar"]

