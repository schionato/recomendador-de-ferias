package com.schionato.tempo;

import com.schionato.tempo.feriado.Feriados;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiaTest {

    private VerificadorDiaUtil finalSemana;

    @Before
    public void setUp() {
        finalSemana = new FinalDeSemana();
    }

    @Test
    public void segundaFeiraEhUmDiaUtil() {
        Dia segundaFeira = new Dia("22/01/2018");
        assertTrue(segundaFeira.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void tercaEhUmDiaUtil() {
        Dia tercaFeira = new Dia("23/01/2018");
        assertTrue(tercaFeira.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void quartaEhUmDiaUtil() {
        Dia quartaFeira = new Dia("24/01/2018");
        assertTrue(quartaFeira.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void quintaEhUmDiaUtil() {
        Dia quintaFeira = new Dia("25/01/2018");
        assertTrue(quintaFeira.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void sextaEhUmDiaUtil() {
        Dia sextaFeira = new Dia("26/01/2018");
        assertTrue(sextaFeira.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void sabadoEhUmDiaUtil() {
        Dia sabado = new Dia("27/01/2018");
        assertFalse(sabado.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void domingoEhUmDiaUtil() {
        Dia dominho = new Dia("28/01/2018");
        assertFalse(dominho.ehUmDiaUtil(singletonList(finalSemana)));
    }

    @Test
    public void dia7DeSetembroEhUmDiaUtil() {
        Feriados feriados = mock(Feriados.class);
        when(feriados.check(any())).thenReturn(false);

        Dia diaIndependencia = new Dia("07/09/2018");
        assertFalse(diaIndependencia.ehUmDiaUtil(asList(finalSemana, feriados)));
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