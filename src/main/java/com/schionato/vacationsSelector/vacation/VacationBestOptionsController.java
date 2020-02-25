package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.Day;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacations")
public class VacationBestOptionsController {

    private final VacationsBestOptionsService service;

    public VacationBestOptionsController(VacationsBestOptionsService service) {
        this.service = service;
    }

    @GetMapping("/finder")
    public List<VacationDto> findBestPeriods(@RequestParam("start-date") String startDate,
                                             @RequestParam("end-date") String finalDate,
                                             @RequestParam("days-off") int daysOff) {
        var startDay = new Day(startDate);
        var finalDay = new Day(finalDate);
        return service.findOptions(startDay, finalDay, daysOff).stream()
                .map(Vacation::toDto)
                .collect(Collectors.toList());
    }

}
