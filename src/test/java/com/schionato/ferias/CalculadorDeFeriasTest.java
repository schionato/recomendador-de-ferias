package com.schionato.ferias;

import com.schionato.tempo.FinalDeSemana;
import com.schionato.tempo.VerificadorDiaUtil;
import org.junit.Before;
import org.junit.Test;
import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class CalculadorDeFeriasTest {

    private VerificadorDiaUtil finalSemana;

    @Before
    public void setUp() {
        finalSemana = new FinalDeSemana();
    }

    @Test
    public void verificaMelhorPeriodo() {
        Dia dataInicial = new Dia("01/01/2018");
        Dia dataFinal = new Dia("31/01/2018");

        Periodo periodoASerAnalisado = new Periodo(dataInicial, dataFinal, singletonList(finalSemana));

        List<Ferias> melhoresFerias = new CalculadorDeFerias(10, periodoASerAnalisado).getMelhoresResultados();

        assertEquals(3, melhoresFerias.size());

        melhoresFerias.stream().mapToInt(Ferias::size).forEach(quantidadeDias -> assertEquals(12, quantidadeDias));
    }

    @Test
    public void adicionaFinalDeSemanaNoPeriodo() {
        Dia segundaFeira = new Dia("01/01/2018");
        Dia outraSegunda = new Dia("08/01/2018");

        Periodo periodoASerAnalisado = new Periodo(segundaFeira, outraSegunda, singletonList(finalSemana));

        List<Ferias> ferias = new CalculadorDeFerias(5, periodoASerAnalisado).getMelhoresResultados();

        assertEquals(7, ferias.get(0).size());
    }

}