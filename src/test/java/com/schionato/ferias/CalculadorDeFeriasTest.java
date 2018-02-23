package com.schionato.ferias;

import com.schionato.tempo.FinalDeSemana;
import com.schionato.tempo.DiaNaoTrabalhavel;
import org.junit.Before;
import org.junit.Test;
import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculadorDeFeriasTest {

    private List<DiaNaoTrabalhavel> diasNaoTrabalhaveis;

    @Before
    public void setUp() {
        diasNaoTrabalhaveis = Collections.singletonList(new FinalDeSemana());
    }

    @Test
    public void verificaMelhorPeriodo() {
        Dia dataInicial = new Dia("01/01/9999");
        Dia dataFinal = new Dia("31/01/9999");

        Periodo periodoASerAnalisado = new Periodo(dataInicial, dataFinal, diasNaoTrabalhaveis);

        List<Ferias> melhoresFerias = new CalculadorDeFerias(10, periodoASerAnalisado).getMelhoresResultados();

        assertEquals(3, melhoresFerias.size());

        melhoresFerias.stream().mapToInt(Ferias::size).forEach(quantidadeDias -> assertEquals(12, quantidadeDias));
    }

    @Test
    public void adicionaFinalDeSemanaNoPeriodo() {
        Dia segundaFeira = new Dia("04/01/9999");
        Dia outraSegunda = new Dia("11/01/9999");

        Periodo periodoASerAnalisado = new Periodo(segundaFeira, outraSegunda, diasNaoTrabalhaveis);

        List<Ferias> ferias = new CalculadorDeFerias(5, periodoASerAnalisado).getMelhoresResultados();

        assertEquals(7, ferias.get(0).size());
    }

}