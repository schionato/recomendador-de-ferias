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

    //FIXME nome esta errado
    List<Periodo> gerarSubPeriodos(int quantidadeDiasSubPeriodos) {
        List<Periodo> subPeriodos = new ArrayList<>();

        for (int i = 0; i < dias.size() - quantidadeDiasSubPeriodos; i++) {
            Dia dia = dias.get(i);

            if (dia.ehFinalDeSemana()) {
                continue;
            }

            List<Dia> diasSubPeriodo = new ArrayList<>();
            diasSubPeriodo.add(dia);

            for (int x = 1; x < quantidadeDiasSubPeriodos; x++) {
                diasSubPeriodo.add(dias.get(i + x));
            }

            verificaSeProximoDiaEhUtil(diasSubPeriodo);

            subPeriodos.add(new Periodo(diasSubPeriodo));
        }

        return subPeriodos;
    }

    private void verificaSeProximoDiaEhUtil(List<Dia> diasSubPeriodo) {
        Dia ultimoDia = diasSubPeriodo.get(diasSubPeriodo.size() -1);

        if (ultimoDia.getAmanha().ehFinalDeSemana()) {
            diasSubPeriodo.add(ultimoDia.getAmanha());
            verificaSeProximoDiaEhUtil(diasSubPeriodo);
        }
    }

    public long getQuantidadeDeDiasUteis() {
        return dias.stream().filter(Dia::ehUmDiaUtil).count();
    }

    public int size() {
        return dias.size();
    }
}
