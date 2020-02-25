package com.schionato.vacationsSelector.date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PeriodDto {
    String startDate;
    String endDate;
}
