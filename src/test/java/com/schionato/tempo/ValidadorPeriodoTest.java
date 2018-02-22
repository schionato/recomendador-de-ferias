package com.schionato.tempo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidadorPeriodoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verificaDataInicialMaiorQueDataFinal() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("A data final tem que ser maior que data inicial");

        new ValidadorPeriodo(new Dia("30/01/2018"), new Dia("01/01/2018")).verifica();
    }

    @Test
    public void verificaDataInicialMenorQueHoje() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("A data inicial tem que ser maior ou igual a hoje");

        new ValidadorPeriodo(new Ontem(), new Amanha()).verifica();
    }
}