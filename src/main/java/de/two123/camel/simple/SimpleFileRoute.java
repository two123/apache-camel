package de.two123.camel.simple;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleFileRoute extends RouteBuilder {
  @Override
  public void configure() {
    from("direct:fileStart")
        .log("SimpleFileRoute")
        .routeId("SimpleFileRoute")
        .transform().constant("Hello World!")
        .log("body: ${body}")
        .to("file:output")
    ;
  }
}
