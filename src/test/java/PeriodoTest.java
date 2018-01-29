import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeriodoTest {

    @Test
    public void contaQuantidadeDeDiasUteis() {
        Dia diaInicial = new Dia("01/01/2018");
        Dia diaFinal = new Dia("30/01/2018");

        Periodo periodo = new Periodo(diaInicial, diaFinal);
        assertEquals(22, periodo.getQuantidadeDeDiasUteis());
    }

}