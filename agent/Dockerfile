FROM openjdk:11-jdk-slim
COPY target/agent.jar /opt/agent.jar
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar","/opt/agent.jar"]
EXPOSE 8003
