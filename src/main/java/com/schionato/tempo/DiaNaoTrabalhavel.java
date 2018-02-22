package com.schionato.tempo;

import com.schionato.tempo.feriado.Feriados;

import java.util.Arrays;
import java.util.List;

public interface DiaNaoTrabalhavel {

    static List<DiaNaoTrabalhavel> getDefault() {
        return Arrays.asList(new FinalDeSemana(), new Feriados());
    }

    boolean eh(Dia dia);

}
