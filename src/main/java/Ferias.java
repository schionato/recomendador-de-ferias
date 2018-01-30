class Ferias {

    private final Periodo periodo;

    Ferias(Periodo periodo) {
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

    long getQuantidadeDeDiasUteis() {
        return periodo.getQuantidadeDeDiasUteis();
    }

    int size() {
        return periodo.size();
    }
}
