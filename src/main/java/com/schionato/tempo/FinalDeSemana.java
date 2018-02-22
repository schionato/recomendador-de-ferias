package com.schionato.tempo;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class FinalDeSemana implements DiaNaoTrabalhavel {

    private static final List<Integer> DIAS_FINAL_DE_SEMANA = Arrays.asList(
            DayOfWeek.SUNDAY.getValue(),
            DayOfWeek.SATURDAY.getValue()
    );

    @Override
    public boolean eh(Dia dia) {
        return DIAS_FINAL_DE_SEMANA.contains(dia.getDiaDaSemana().getValue());
    }
}
