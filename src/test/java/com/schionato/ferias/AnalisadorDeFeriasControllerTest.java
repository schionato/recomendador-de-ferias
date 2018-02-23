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
                "data-inicio=01/12/9999&" +
                "data-fim=10/12/9999&" +
                "quantidade=3", List.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String expected = "[{periodo={dataInicio=01/12/9999, dataFinal=05/12/9999}, quantidadeDias=5}]";
        assertEquals(expected, response.getBody().toString());
    }

    @Test
    public void getAnalisesComDataInicioMaiorDataFimErro400() {
        ResponseEntity<?> response = super.get("/api/v1/analises?" +
                "data-inicio=10/12/9999&" +
                "data-fim=01/12/9999&" +
                "quantidade=3", String.class);

        String expectedMessage = "{\"message\":\"A data final tem que ser maior que data inicial\"}";

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    public void getAnalisesSemPassarDataInicio() {
        ResponseEntity<?> response = super.get("/api/v1/analises?"+
                "data-fim=01/12/9999&" +
                "quantidade=3", String.class);

        String expectedMessage = "{\"message\":\"Required String parameter 'data-inicio' is not present\"}";

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }
}