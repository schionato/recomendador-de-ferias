package com.schionato.ferias;

import com.schionato.configuracao.HttpIntegrationTest;
import org.junit.Test;

public class AnalisadorDeFeriasControllerTest extends HttpIntegrationTest {

    @Test
    public void analises() {
        String response = super.get("/api/v1/analises?" +
                "data-inicio=01/01/2018&" +
                "data-fim=30/02/2018" +
                "&quantidade=3");
        System.out.println(response);
    }
}