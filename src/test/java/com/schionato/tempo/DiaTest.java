package com.schionato.tempo;

import com.schionato.tempo.feriado.Feriados;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiaTest {

    private List<DiaNaoTrabalhavel> finaisDeSemana;

    @Before
    public void setUp() {
        finaisDeSemana = singletonList(new FinalDeSemana());
    }

    @Test
    public void segundaFeiraEhUmDiaUtil() {
        Dia segundaFeira = new Dia("22/01/2018");

        assertFalse(segundaFeira.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void tercaEhUmDiaUtil() {
        Dia tercaFeira = new Dia("23/01/2018");

        assertFalse(tercaFeira.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void quartaEhUmDiaUtil() {
        Dia quartaFeira = new Dia("24/01/2018");

        assertFalse(quartaFeira.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void quintaEhUmDiaUtil() {
        Dia quintaFeira = new Dia("25/01/2018");

        assertFalse(quintaFeira.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void sextaEhUmDiaUtil() {
        Dia sextaFeira = new Dia("26/01/2018");

        assertFalse(sextaFeira.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void sabadoEhUmDiaUtil() {
        Dia sabado = new Dia("27/01/2018");

        assertTrue(sabado.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void domingoEhUmDiaUtil() {
        Dia dominho = new Dia("28/01/2018");

        assertTrue(dominho.estaInlcusoNos(finaisDeSemana));
    }

    @Test
    public void dia7DeSetembroEhUmDiaUtil() {
        Feriados feriados = mock(Feriados.class);
        when(feriados.eh(any())).thenReturn(true);

        Dia diaIndependencia = new Dia("07/09/2018");
        assertTrue(diaIndependencia.estaInlcusoNos(asList(new FinalDeSemana(), feriados)));
    }

    @Test
    public void toData() throws ParseException {
        Dia dia = new Dia("22/09/1987");

        Date expected = new SimpleDateFormat("dd/MM/yyyy").parse("22/09/1987");

        assertFalse(expected.after(dia.toData()));
        assertFalse(expected.before(dia.toData()));
    }

    @Test
    public void ontemEhAntesDeHoje() {
        assertTrue(new Ontem().antes(new Hoje()));
    }

    @Test
    public void ontemNaoEhIgualAHoje() {
        assertFalse(new Ontem().igual(new Hoje()));
    }

    @Test
    public void hojeEhIgualAHoje() {
        assertTrue(new Hoje().igual(new Hoje()));
    }

    @Test
    public void hojeNaoEhIgualAOntem() {
        assertFalse(new Hoje().igual(new Ontem()));
    }
}