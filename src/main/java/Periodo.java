import java.util.ArrayList;
import java.util.List;

class Periodo {

    private final List<Dia> dias;

    private Periodo(List<Dia> dias) {
        this.dias = new ArrayList<>(dias);
    }

    Periodo(Dia dataInicial, Dia dataFinal) {
        this.dias = new GeradorDePeriodo(dataInicial, dataFinal).getDias();
    }

    List<Ferias> gerarFerias(int quantidadeDias) {
        List<Ferias> possiveisFerias = new ArrayList<>();

        for (int i = 0; i < dias.size() - quantidadeDias; i++) {
            Dia dia = dias.get(i);

            if (dia.ehFinalDeSemana()) {
                continue;
            }

            Periodo periodo = new Periodo(dias.subList(i, i + quantidadeDias));

            possiveisFerias.add(new Ferias(periodo));
        }

        return possiveisFerias;
    }

    public long getQuantidadeDeDiasUteis() {
        return dias.stream().filter(Dia::ehUmDiaUtil).count();
    }

    public int size() {
        return dias.size();
    }

    Dia getUltimoDia() {
        return dias.get(dias.size() - 1);
    }

    void add(Dia dia) {
        this.dias.add(dia);
    }
}
