package com.schionato.tempo;

import com.schionato.ferias.Ferias;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class PeriodoTest {

    private VerificadorDiaUtil finalSemana;

    @Before
    public void setUp() {
        finalSemana = new FinalDeSemana();
    }

    @Test
    public void contaQuantidadeDeDiasUteis() {
        Dia diaInicial = new Dia("01/01/2018");
        Dia diaFinal = new Dia("30/01/2018");

        Periodo periodo = new Periodo(diaInicial, diaFinal, singletonList(finalSemana));
        assertEquals(22, periodo.getQuantidadeDeDiasUteis());
    }

    @Test
    public void gerarSubPeriodos() {
        Dia diaInicial = new Dia("01/01/2018");
        Dia diaFinal = new Dia("30/01/2018");

        Periodo periodo = new Periodo(diaInicial, diaFinal, singletonList(finalSemana));
        List<Ferias> periodos = periodo.gerarFerias(10);

        assertEquals(15, periodos.size());
        assertEquals(12, periodos.stream().mapToInt(Ferias::size).max().getAsInt());
    }
}