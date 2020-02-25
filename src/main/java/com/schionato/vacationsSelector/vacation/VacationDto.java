package com.schionato.vacationsSelector.vacation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.schionato.vacationsSelector.date.PeriodDto;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class VacationDto {

    @JsonInclude
    PeriodDto period;

    @JsonInclude
    int daysOff;

}
