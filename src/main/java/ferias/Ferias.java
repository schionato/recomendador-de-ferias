package ferias;

import tempo.Dia;
import tempo.Periodo;

public class Ferias {

    private final Periodo periodo;

    public Ferias(Periodo periodo) {
        this.periodo = periodo;
        verificaSeProximosDiasSaoDescansaveis();
    }

    private void verificaSeProximosDiasSaoDescansaveis() {
        Dia proximoDia = periodo.getUltimoDia().getAmanha();

        if (proximoDia.ehFinalDeSemana()) {
            periodo.add(proximoDia);
            verificaSeProximosDiasSaoDescansaveis();
        }
    }

    public int size() {
        return periodo.size();
    }
}
