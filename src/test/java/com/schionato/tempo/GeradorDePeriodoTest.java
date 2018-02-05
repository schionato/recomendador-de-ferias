package com.schionato.tempo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeradorDePeriodoTest {

    @Test
    public void geraOsDiasDoMesDeJaneiro() {
        Dia diaPrimeiro = new Dia("01/01/2018");
        Dia diaTrintaUm = new Dia("31/01/2018");

        List<Dia> dias = new GeradorDePeriodo(diaPrimeiro, diaTrintaUm).getDias();
        assertEquals(31, dias.size());

        for (int i = 0; i < 31; i++) {
            Dia dia = dias.get(i);
            assertEquals(i +1, dia.getDiaDoMes());
        }
    }
}