package com.schionato.ferias;

import com.schionato.configuracao.HttpIntegrationTest;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnalisadorDeFeriasControllerTest extends HttpIntegrationTest {

    @Test
    public void analises() {
        ResponseEntity<?> response = super.get("/api/v1/analises?" +
                "data-inicio=01/01/2018&" +
                "data-fim=10/01/2018&" +
                "quantidade=3", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String expected = "[{periodo={dataInicio=03/01/2018, dataFinal=07/01/2018}, quantidadeDias=5}]";
        assertEquals(expected, response.getBody().toString());
    }
}