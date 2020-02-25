package com.schionato.vacationsSelector.date;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeradorDePeriodTest {

    @Test
    public void geraOsDiasDoMesDeJaneiro() {
        Day diaPrimeiro = new Day("01/01/2018");
        Day diaTrintaUm = new Day("31/01/2018");

        List<Day> dias = new PeriodsGenerator(diaPrimeiro, diaTrintaUm).getDays();
        assertEquals(31, dias.size());

        for (int i = 0; i < 31; i++) {
            Day dia = dias.get(i);
            assertEquals(i +1, dia.getDayOfMonth());
        }
    }
}