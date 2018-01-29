import java.util.ArrayList;
import java.util.List;

class Periodo {

    private final Dia dataInicial;
    private final Dia dataFinal;

    Periodo(Dia dataInicial, Dia dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public long getQuantidadeDeDiasUteis() {
        List<Dia> todosOsDias = new ArrayList<>();

        for (Dia dia = dataInicial;
             dia.antes(dataFinal) || dia.igual(dataFinal);
             dia = dia.getAmanha()) {
            todosOsDias.add(dia);
        }

        return todosOsDias.stream().filter(Dia::ehUmDiaUtil).count();
    }
}
