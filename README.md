# Apache Camel Demo with Spring Boot

## Getting Started

### [Simple Rest Route](src/main/java/de/two123/camel/simple/SimpleRestRoute.java)

> curl http://localhost:8080/camel/say/hello

> curl http://localhost:8080/camel/say/bye

### [Simple File Route](src/main/java/de/two123/camel/simple/SimpleFileRoute.java)

### RabbitMQ

*Install Podman (macOS)*
> brew install podman

*Start Podman*

> podman machine init<br>
> podman machine start

*IntelliJ & Podman*

1. Settings - Build, Execution, Deployment - Docker
2. New Profile "Podman" - SSH:
   - SSH: core@127.0.0.1:62167
   - Private Key <i>(macOS)</i>: /Users/<b>USER</b>/.ssh/podman-machine-default

*RabbitMQ*
> podman pull rabbitmq
>

## Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/gradle-plugin/reference/html/#build-image)

## Guides

The following guides illustrate how to use some features concretely:

* [Using Apache Camel with Spring Boot](https://camel.apache.org/camel-spring-boot/latest/spring-boot.html)

## Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
