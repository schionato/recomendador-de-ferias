package com.schionato.ferias;

import com.schionato.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = App.class)
public class AnalisadorDeFeriasControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void name() {
        String url = "http://localhost:" + port + "/api/v1/analises?data-inicio=01/01/2018&data-fim=30/02/2018&quantidade=3";
        String response = this.restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}