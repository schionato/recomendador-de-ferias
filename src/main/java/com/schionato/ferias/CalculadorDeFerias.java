package com.schionato.ferias;

import com.schionato.tempo.Periodo;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class CalculadorDeFerias {

    private final Map<Integer, List<Ferias>> sugestoesDeFerias;

    CalculadorDeFerias(int quantidadeDiasSolicitados, Periodo periodoASerAnalisado) {
        this.sugestoesDeFerias = periodoASerAnalisado.gerarFerias(quantidadeDiasSolicitados).stream()
                .collect(groupingBy(Ferias::size));
    }

    public List<Ferias> getMelhoresResultados() {
        int maiorPeriodo = this.sugestoesDeFerias.keySet()
                .stream()
                .mapToInt(quantidade -> quantidade)
                .max()
                .orElseThrow(RuntimeException::new);
        return this.sugestoesDeFerias.get(maiorPeriodo);
    }
}
