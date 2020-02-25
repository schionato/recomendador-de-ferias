package com.schionato.vacationsSelector.date.holiday;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Holidays extends DayOffByDefault, JpaRepository<Holiday, Long> {

    @Override
    default boolean in(Day day) {
        return !findAll(Example.of(new Holiday(day.toData()))).isEmpty();
    }
}
