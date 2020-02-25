package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import org.junit.Before;
import org.junit.Test;
import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.Period;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BestVacationsPeriodsSelectorTest {

    private List<DayOffByDefault> diasNaoTrabalhaveis;

    @Before
    public void setUp() {
        diasNaoTrabalhaveis = Collections.singletonList(new Weekends());
    }

    @Test
    public void verificaMelhorPeriodo() {
        Day dataInicial = new Day("01/01/9999");
        Day dataFinal = new Day("31/01/9999");

        Period periodASerAnalisado = new Period(dataInicial, dataFinal, diasNaoTrabalhaveis);

        List<Vacation> melhoresFerias = new BestVacationsPeriodsSelector(10, periodASerAnalisado).getBestResults();

        assertEquals(3, melhoresFerias.size());

        melhoresFerias.stream().mapToInt(Vacation::size).forEach(quantidadeDias -> assertEquals(12, quantidadeDias));
    }

    @Test
    public void adicionaFinalDeSemanaNoPeriodo() {
        Day segundaFeira = new Day("04/01/9999");
        Day outraSegunda = new Day("11/01/9999");

        Period periodASerAnalisado = new Period(segundaFeira, outraSegunda, diasNaoTrabalhaveis);

        List<Vacation> ferias = new BestVacationsPeriodsSelector(5, periodASerAnalisado).getBestResults();

        assertEquals(7, ferias.get(0).size());
    }

}