package com.schionato.vacationsSelector.date.holiday;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    private Holiday() {} //JPA compatibility

    public Holiday(Date date) {
        this.date = date;
    }
}
