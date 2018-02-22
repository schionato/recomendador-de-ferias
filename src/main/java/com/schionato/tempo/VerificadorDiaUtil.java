package com.schionato.tempo;

import com.schionato.tempo.feriado.Feriados;

import java.util.Arrays;
import java.util.List;

//TODO mudar para DiaNaoTrabalhavel
public interface VerificadorDiaUtil {

    static List<VerificadorDiaUtil> getDefault() {
        return Arrays.asList(new FinalDeSemana(), new Feriados());
    }

    //TODO mudar para eh(Dia dia)
    boolean check(Dia dia);

}
