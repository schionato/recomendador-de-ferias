package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.period.Period;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class BestVacationsPeriodsSelector {

    private final Map<Integer, List<Vacation>> allVacationsPeriodsGroupedByDaysOff;

    BestVacationsPeriodsSelector(int quantidadeDiasSolicitados, Period periodASerAnalisado) {
        this.allVacationsPeriodsGroupedByDaysOff = periodASerAnalisado.generate(quantidadeDiasSolicitados).stream()
                .collect(groupingBy(Vacation::size));
    }

    public List<Vacation> getBestResults() {
        int maxDaysOffsPossible = allVacationsPeriodsGroupedByDaysOff.keySet()
                .stream()
                .mapToInt(daysOff -> daysOff)
                .max()
                .orElseThrow(RuntimeException::new);
        return allVacationsPeriodsGroupedByDaysOff.get(maxDaysOffsPossible);
    }
}
