package com.udacity.pricingservice;

import com.udacity.pricingservice.entity.Price;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PricingServiceApplicationTests {

    private final String host = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void getAllPrices() {
        ResponseEntity<String> response = this.restTemplate.getForEntity(host + port + "/prices", String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    void getPrice() {
        ResponseEntity<Price> response = this.restTemplate.getForEntity(host + port + "/prices/1", Price.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    void containsData() {
        ResponseEntity<Price> response = this.restTemplate.getForEntity(host + port + "/prices/1", Price.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(Objects.requireNonNull(response.getBody()).getCurrency(), equalTo("USD"));
    }

}
