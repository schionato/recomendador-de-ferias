import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CalculadorDeFerias {

    private final int diasSolicitados;
    private final Periodo periodoASerAnalisado;
    private final Map<Long, List<Ferias>> periodos;

    CalculadorDeFerias(int diasSolicitados, Periodo periodoASerAnalisado) {
        this.diasSolicitados = diasSolicitados;
        this.periodoASerAnalisado = periodoASerAnalisado;
        this.periodos = new HashMap<>();
    }

    CalculadorDeFerias calcula() {
        List<Ferias> possiveisFerias = periodoASerAnalisado.gerarFerias(diasSolicitados);

        for (Ferias ferias : possiveisFerias) {
            long quantidadeDiasUteis = ferias.getQuantidadeDeDiasUteis();

            this.periodos.computeIfAbsent(quantidadeDiasUteis, quantidade -> {
                List<Ferias> todasFerias = new ArrayList<>();
                todasFerias.add(ferias);
                return todasFerias;
            });

            this.periodos.computeIfPresent(quantidadeDiasUteis, (quantidade, periodos) -> {
                periodos.add(ferias);
                return periodos;
            });
        }
        return this;
    }

    public List<Ferias> getMelhoresPeriodos() {
        long maiorPeriodo = this.periodos.keySet()
                .stream()
                .mapToLong(quantidade -> quantidade)
                .max()
                .orElseThrow(RuntimeException::new);
        return this.periodos.get(maiorPeriodo);
    }
}
