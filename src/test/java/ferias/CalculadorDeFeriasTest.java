package ferias;

import org.junit.Test;
import tempo.Dia;
import tempo.Periodo;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculadorDeFeriasTest {

    @Test
    public void verificaMelhorPeriodo() {
        Dia dataInicial = new Dia("01/01/2018");
        Dia dataFinal = new Dia("31/01/2018");

        Periodo periodoASerAnalisado = new Periodo(dataInicial, dataFinal);

        List<Ferias> melhoresFerias = new CalculadorDeFerias(10, periodoASerAnalisado).getMelhoresPeriodos();

        assertEquals(3, melhoresFerias.size());

        melhoresFerias.stream().mapToInt(Ferias::size).forEach(quantidadeDias -> assertEquals(12, quantidadeDias));
    }

    @Test
    public void adicionaFinalDeSemanaNoPeriodo() {
        Dia segundaFeira = new Dia("01/01/2018");
        Dia outraSegunda = new Dia("08/01/2018");

        Periodo periodoASerAnalisado = new Periodo(segundaFeira, outraSegunda);

        List<Ferias> ferias = new CalculadorDeFerias(5, periodoASerAnalisado).getMelhoresPeriodos();

        assertEquals(7, ferias.get(0).size());
    }

}