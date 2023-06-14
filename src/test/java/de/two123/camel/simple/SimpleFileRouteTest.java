package de.two123.camel.simple;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CamelSpringBootTest
class SimpleFileRouteTest {

  @Autowired
  CamelContext camelContext;

  @Autowired
  ProducerTemplate producerTemplate;

  final String fileName = "simple-file.txt";

  final File file = new File("output/" + fileName);

  @BeforeEach
  void setup() throws IOException {
    Files.deleteIfExists(Paths.get(file.getAbsolutePath()));
  }

  @AfterEach
  void cleanup() throws IOException {
    Files.deleteIfExists(Paths.get(file.getAbsolutePath()));
  }

  @Test
  public void testWithoutMock() throws IOException {
    Exchange exchange = new DefaultExchange(camelContext);
    exchange.getMessage().setBody("in-message");
    exchange.getMessage().setHeader(Exchange.FILE_NAME, fileName);

    Exchange resultExchange = producerTemplate.send("direct:fileStart", exchange);
    assertThat(resultExchange.getMessage().getBody()).isEqualTo("Hello World!");
    assertThat(Files.readString(Paths.get(file.getAbsolutePath()))).isEqualTo("Hello World!");
  }
}
