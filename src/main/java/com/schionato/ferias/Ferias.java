package com.schionato.ferias;

import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;
import com.schionato.tempo.PeriodoDto;

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

    public FeriasDto toDto() {
        FeriasDto dto = new FeriasDto();
        dto.setPeriodo(this.periodo.toDto());
        dto.setQuantidadeDias(this.size());
        return dto;
    }
}
