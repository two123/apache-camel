package de.two123.camel.simple;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SimpleRestRoute extends RouteBuilder {

  @Override
  public void configure() {
    restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);

    rest()
        .path("/say")

        .get("/hello")
        .produces("text/plain")
        .outType(String.class)
        .to("direct:hello")

        .get("/bye")
        .produces("text/plain")
        .outType(String.class)
        .to("direct:bye")
    ;

    from("direct:hello")
        .routeId("Hello Route")
        .transform().constant("Hello World!");

    from("direct:bye")
        .routeId("Bye Route")
        .transform().constant("Bye World!");
  }
}
