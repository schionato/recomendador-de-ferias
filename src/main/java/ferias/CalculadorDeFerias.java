package ferias;

import tempo.Periodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CalculadorDeFerias {

    private final int quantidadeDiasSolicitados;
    private final Periodo periodoASerAnalisado;
    private final Map<Long, List<Ferias>> sugestoesDeFerias;

    CalculadorDeFerias(int quantidadeDiasSolicitados, Periodo periodoASerAnalisado) {
        this.quantidadeDiasSolicitados = quantidadeDiasSolicitados;
        this.periodoASerAnalisado = periodoASerAnalisado;
        this.sugestoesDeFerias = new HashMap<>();
    }

    CalculadorDeFerias calcula() {
        List<Ferias> possiveisFerias = periodoASerAnalisado.gerarFerias(quantidadeDiasSolicitados);

        for (Ferias ferias : possiveisFerias) {
            long quantidadeDiasUteis = ferias.getQuantidadeDeDiasUteis();

            this.sugestoesDeFerias.computeIfAbsent(quantidadeDiasUteis, quantidade -> {
                List<Ferias> todasFerias = new ArrayList<>();
                todasFerias.add(ferias);
                return todasFerias;
            });

            this.sugestoesDeFerias.computeIfPresent(quantidadeDiasUteis, (quantidade, periodos) -> {
                periodos.add(ferias);
                return periodos;
            });
        }
        return this;
    }

    public List<Ferias> getMelhoresPeriodos() {
        long maiorPeriodo = this.sugestoesDeFerias.keySet()
                .stream()
                .mapToLong(quantidade -> quantidade)
                .max()
                .orElseThrow(RuntimeException::new);
        return this.sugestoesDeFerias.get(maiorPeriodo);
    }
}
