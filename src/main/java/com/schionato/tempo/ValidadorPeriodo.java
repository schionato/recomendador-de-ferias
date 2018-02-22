package com.schionato.tempo;

public class ValidadorPeriodo {

    private final Dia dataInicial;
    private final Dia dataFinal;

    ValidadorPeriodo(Dia dataInicial, Dia dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    void verifica() {
        if (dataFinal.antes(dataInicial)) {
            throw new IllegalArgumentException("A data final tem que ser maior que data inicial");
        }
    }
}
