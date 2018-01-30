package ferias;

import tempo.Periodo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class CalculadorDeFerias {

    private final int quantidadeDiasSolicitados;
    private final Periodo periodoASerAnalisado;
    private final Map<Integer, List<Ferias>> sugestoesDeFerias;

    CalculadorDeFerias(int quantidadeDiasSolicitados, Periodo periodoASerAnalisado) {
        this.quantidadeDiasSolicitados = quantidadeDiasSolicitados;
        this.periodoASerAnalisado = periodoASerAnalisado;
        this.sugestoesDeFerias = new HashMap<>();
    }

    CalculadorDeFerias calcula() {
        Map<Integer, List<Ferias>> sugestoes = periodoASerAnalisado.gerarFerias(quantidadeDiasSolicitados)
                .stream()
                .collect(groupingBy(Ferias::size));

        this.sugestoesDeFerias.putAll(sugestoes);
        return this;
    }

    public List<Ferias> getMelhoresPeriodos() {
        int maiorPeriodo = this.sugestoesDeFerias.keySet()
                .stream()
                .mapToInt(quantidade -> quantidade)
                .max()
                .orElseThrow(RuntimeException::new);
        return this.sugestoesDeFerias.get(maiorPeriodo);
    }
}
