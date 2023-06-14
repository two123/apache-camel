package de.two123.camel.simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@CamelSpringBootTest
class SimpleRestRouteTest {

  @LocalServerPort
  int port;

  String baseUrl;

  TestRestTemplate restTemplate = new TestRestTemplate();

  @BeforeEach
  void setup() {
    baseUrl = "http://localhost:" + port + "/camel/say/";
  }

  @Test
  public void hello() {
    ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "hello", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Hello World!");
  }

  @Test
  public void bye() {
    ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "bye", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Bye World!");
  }
}
