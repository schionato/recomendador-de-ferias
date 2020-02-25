package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.date.holiday.Holidays;
import org.springframework.stereotype.Service;
import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.period.Period;

import java.util.Arrays;
import java.util.List;

@Service
class VacationsBestOptionsService {

    private final Holidays holidays;
    private final Weekends finaisDeSemana;

    public VacationsBestOptionsService(Holidays holidays, Weekends finaisDeSemana) {
        this.holidays = holidays;
        this.finaisDeSemana = finaisDeSemana;
    }

    List<Vacation> findOptions(Day dataInicio, Day dataFinal, int quantidadeDias) {
        var diasNaoTrabalhaveis = Arrays.asList(holidays, finaisDeSemana);
        var periodo = new Period(dataInicio, dataFinal, diasNaoTrabalhaveis);
        return new BestVacationsPeriodsSelector(quantidadeDias, periodo).getBestResults();
    }

}
