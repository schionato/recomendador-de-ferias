import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CalculadorDeFerias {

    private final int diasSolicitados;
    private final Periodo periodoASerAnalisado;
    private final Map<Long, List<Periodo>> periodos;

    CalculadorDeFerias(int diasSolicitados, Periodo periodoASerAnalisado) {
        this.diasSolicitados = diasSolicitados;
        this.periodoASerAnalisado = periodoASerAnalisado;
        this.periodos = new HashMap<>();
    }

    CalculadorDeFerias calcula() {
        List<Periodo> subPeriodos = periodoASerAnalisado.gerarSubPeriodos(diasSolicitados);

        for (Periodo periodo : subPeriodos) {
            long quantidadeDiasUteis = periodo.getQuantidadeDeDiasUteis();

            this.periodos.computeIfAbsent(quantidadeDiasUteis, aLong -> {
                List<Periodo> periodos = new ArrayList<>();
                periodos.add(periodo);
                return periodos;
            });

            this.periodos.computeIfPresent(quantidadeDiasUteis, (quantidade, periodos) -> {
                periodos.add(periodo);
                return periodos;
            });
        }
        return this;
    }

    public List<Periodo> getMelhoresPeriodos() {
        long maiorPeriodo = this.periodos.keySet()
                .stream()
                .mapToLong(quantidade -> quantidade)
                .max()
                .orElseThrow(RuntimeException::new);
        return this.periodos.get(maiorPeriodo);
    }
}
