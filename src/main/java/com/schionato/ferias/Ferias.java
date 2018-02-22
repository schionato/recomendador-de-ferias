package com.schionato.ferias;

import com.schionato.tempo.Dia;
import com.schionato.tempo.DiaNaoTrabalhavel;
import com.schionato.tempo.Periodo;

import java.util.List;

public class Ferias {

    private final Periodo periodo;
    private final List<DiaNaoTrabalhavel> diasNaoTrabalhaveis;

    public Ferias(Periodo periodo, List<DiaNaoTrabalhavel> diasNaoTrabalhaveis) {
        this.periodo = periodo;
        this.diasNaoTrabalhaveis = diasNaoTrabalhaveis;
        verificaSeProximosDiasSaoDescansaveis();
    }

    private void verificaSeProximosDiasSaoDescansaveis() {
        Dia proximoDia = periodo.getUltimoDia().getAmanha();

        if (proximoDia.estaInlcusoNos(diasNaoTrabalhaveis)) {
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
