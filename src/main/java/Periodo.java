import java.util.ArrayList;
import java.util.List;

class Periodo {

    private final List<Dia> dias;

    public Periodo(List<Dia> dias) {
        this.dias = new ArrayList<>(dias);
    }

    Periodo(Dia dataInicial, Dia dataFinal) {
        this.dias = new GeradorDePeriodo(dataInicial, dataFinal).getDias();
    }

    List<Periodo> gerarSubPeriodos(int quantidadeDiasSubPeriodos) {
        List<Periodo> subPeriodos = new ArrayList<>();

        for (int i = 0; i < dias.size() - quantidadeDiasSubPeriodos; i++) {
            Dia dia = dias.get(i);

            if (dia.ehUmDiaUtil()) {
                List<Dia> diasSubPeriodo = new ArrayList<>();
                diasSubPeriodo.add(dia);

                for (int x = i +1; x < quantidadeDiasSubPeriodos; x++) {
                    diasSubPeriodo.add(dias.get(x));
                }

                subPeriodos.add(new Periodo(diasSubPeriodo));
            }
        }

        return subPeriodos;
    }

    public long getQuantidadeDeDiasUteis() {
        return dias.stream().filter(Dia::ehUmDiaUtil).count();
    }

}
