package com.github.kjit.jpap.dto;

import com.github.kjit.jpap.model.Flight;

import java.text.DateFormat;
import java.util.Date;

public class FlightDto {
    private static final DateFormat formatter = DateFormat.getDateTimeInstance();

    public static FlightDto fromModel(Flight flight) {
        FlightDto dto = new FlightDto();
        dto.id = flight.getId();
        dto.code = flight.getCode();
        dto.departure = flight.getDeparture().getIata() + " " + flight.getDeparture().getFullName();
        dto.destination = flight.getDestination().getIata() + " " + flight.getDestination().getFullName();
        dto.airline = flight.getAirline().getCode() + " " + flight.getAirline().getName();
        dto.std = formatter.format(flight.getStd());
        dto.sta = formatter.format(flight.getSta());
        return dto;
    }

    private Integer id;

    private String code;

    private Long duration;

    private String sta;

    private String std;

    private String airline;

    private String departure;

    private String destination;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
