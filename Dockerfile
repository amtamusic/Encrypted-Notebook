FROM adoptopenjdk/openjdk11:latest
COPY target/Encrypted-Notebook-0.0.1-SNAPSHOT.jar Encrypted-Notebook-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Encrypted-Notebook-0.0.1-SNAPSHOT.jar"]