package com.schionato.ferias;

import com.schionato.tempo.PeriodoDto;

public class FeriasDto {

    private PeriodoDto periodo;
    private int quantidadeDias;

    public PeriodoDto getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoDto periodo) {
        this.periodo = periodo;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
}
