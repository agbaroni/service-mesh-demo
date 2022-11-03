FROM registry.redhat.io/ubi9/openjdk-11

COPY target/service2-1.0.0-runner.jar /

ENTRYPOINT [ "/usr/bin/java", "-jar", "/service2-1.0.0-runner.jar" ]
