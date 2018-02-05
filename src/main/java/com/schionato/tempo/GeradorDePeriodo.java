package com.schionato.tempo;

import java.util.ArrayList;
import java.util.List;

class GeradorDePeriodo {

    private final List<Dia> dias;

    GeradorDePeriodo(Dia dataInicio, Dia dataFim) {
        this.dias = new ArrayList<>();

        for (Dia dia = dataInicio;
             dia.antes(dataFim) || dia.igual(dataFim);
             dia = dia.getAmanha()) {
            dias.add(dia);
        }
    }

    public List<Dia> getDias() {
        return new ArrayList<>(dias);
    }
}
