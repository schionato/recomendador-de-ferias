package com.schionato.tempo;

import com.schionato.ferias.Ferias;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class PeriodoTest {

    private List<DiaNaoTrabalhavel> diasNaoTrabalhaveis;

    @Before
    public void setUp() {
        diasNaoTrabalhaveis = Collections.singletonList(new FinalDeSemana());
    }

    @Test
    public void contaQuantidadeDeDiasUteis() {
        Dia diaInicial = new Dia("01/01/9999");
        Dia diaFinal = new Dia("30/01/9999");

        Periodo periodo = new Periodo(diaInicial, diaFinal, diasNaoTrabalhaveis);
        assertEquals(21, periodo.getQuantidadeDeDiasUteis());
    }

    @Test
    public void gerarSubPeriodos() {
        Dia diaInicial = new Dia("01/01/9999");
        Dia diaFinal = new Dia("30/01/9999");

        Periodo periodo = new Periodo(diaInicial, diaFinal, diasNaoTrabalhaveis);
        List<Ferias> periodos = periodo.gerarFerias(10);

        assertEquals(14, periodos.size());
        assertEquals(12, periodos.stream().mapToInt(Ferias::size).max().getAsInt());
    }
}