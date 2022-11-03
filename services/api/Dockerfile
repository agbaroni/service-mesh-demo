FROM registry.redhat.io/ubi9/openjdk-11

COPY target/api-1.0.0-runner.jar /

ENTRYPOINT [ "/usr/bin/java", "-jar", "/api-1.0.0-runner.jar" ]
