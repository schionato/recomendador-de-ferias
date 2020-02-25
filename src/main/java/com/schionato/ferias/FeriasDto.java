package com.schionato.ferias;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.schionato.tempo.PeriodoDto;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeriasDto {

    @JsonInclude
    PeriodoDto periodo;

    @JsonInclude
    int quantidadeDias;

}
