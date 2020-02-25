package com.schionato.tempo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PeriodoDto {

    String dataInicio;

    String dataFinal;

}
