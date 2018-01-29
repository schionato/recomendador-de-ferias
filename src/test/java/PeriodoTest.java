import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeriodoTest {

    @Test
    public void contaQuantidadeDeDiasUteis() {
        Periodo periodo = new Periodo("01/01/2018", "30/01/2018");
        assertEquals(22, periodo.getQuantidadeDeDiasUteis());
    }

}