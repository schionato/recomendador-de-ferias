package com.schionato.vacationsSelector.vacation;

import com.schionato.configuracao.HttpIntegrationTest;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class VacationBestOptionsControllerTest extends HttpIntegrationTest {

    @Test
    public void findBestOptions() {
        ResponseEntity<?> response = super.get("/api/v1/vacations/finder?" +
                "start-date=01/12/9999&" +
                "end-date=10/12/9999&" +
                "days-off=3", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        String expected = "[{\"period\":{\"startDate\":\"01/12/9999\",\"endDate\":\"05/12/9999\"},\"daysOff\":5}]";
        assertEquals(expected, response.getBody().toString());
    }

    @Test
    public void checkIfGetError400WhenStartDateIsGreaterThanEndDate() {
        ResponseEntity<?> response = super.get("/api/v1/vacations/finder?" +
                "start-date=10/12/9999&" +
                "end-date=01/12/9999&" +
                "days-off=3", String.class);

        String expectedMessage = "{\"message\":\"The end date must be greater than start date\"}";

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    public void checkIfGetError400WhenStartDateIsNotPassed() {
        ResponseEntity<?> response = super.get("/api/v1/vacations/finder?"+
                "end-date=01/12/9999&" +
                "days-off=3", String.class);

        String expectedMessage = "{\"message\":\"Required String parameter 'start-date' is not present\"}";

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }
}