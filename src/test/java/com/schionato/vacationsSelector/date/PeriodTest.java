package com.schionato.vacationsSelector.date;

import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.vacation.Vacation;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    private List<DayOffByDefault> diasNaoTrabalhaveis;

    @Before
    public void setUp() {
        diasNaoTrabalhaveis = Collections.singletonList(new Weekends());
    }

    @Test
    public void contaQuantidadeDeDiasUteis() {
        Day diaInicial = new Day("01/01/9999");
        Day diaFinal = new Day("30/01/9999");

        Period period = new Period(diaInicial, diaFinal, diasNaoTrabalhaveis);
        assertEquals(21, period.countBusinessDay());
    }

    @Test
    public void gerarSubPeriodos() {
        Day diaInicial = new Day("01/01/9999");
        Day diaFinal = new Day("30/01/9999");

        Period period = new Period(diaInicial, diaFinal, diasNaoTrabalhaveis);
        List<Vacation> periodos = period.generate(10);

        assertEquals(14, periodos.size());
        assertEquals(12, periodos.stream().mapToInt(Vacation::size).max().getAsInt());
    }
}