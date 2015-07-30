package com.github.kjit.jpap.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import com.github.kjit.jpap.dao.AirlineDao;
import com.github.kjit.jpap.dao.AirportDao;
import com.github.kjit.jpap.dao.FlightDao;
import com.github.kjit.jpap.dto.Filters;
import com.github.kjit.jpap.dto.FlightDto;
import com.github.kjit.jpap.dto.FlightList;
import com.github.kjit.jpap.model.Airline;
import com.github.kjit.jpap.model.Airport;
import com.github.kjit.jpap.model.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Stateless
public class FlightsService {

	private static final Logger LOG = LoggerFactory.getLogger(FlightsService.class);
	
	@EJB
	FlightDao flightDao;

	@EJB
	AirlineDao airlineDao;

	@EJB
	AirportDao airportDao;
	
	public FlightList getFlights(Filters filters) {
		FlightList flights = new FlightList();
		for (Flight flight : flightDao.getFlights(filters)) {
			flights.getFlights().add(FlightDto.fromModel(flight));
		}
		return flights;
	}

	public String generateFlights(Integer count) {
		for (Airline airline : airlineDao.getAirlineWithoutFlights(count)) {
			LOG.info("airline: {}", airline.getName());
			List<Airport> airports = airportDao.getAirportsWithoutFlights(count * 2);
			for (int i = 0; i < airports.size(); i = i +2) {
				Flight flight = buildFlight(airline, airports.get(i), airports.get(i + 1));
				flightDao.save(flight);
			}
		}
		;
		return "Nothing";
	}

	private Flight buildFlight(Airline airline, Airport departure, Airport destination) {
		Flight f = new Flight();
		airline.addFlight(f);
		f.setCode("F" + airline.getCode() + " - " + departure.getIcao());
		f.setDeparture(departure);
		f.setDestination(destination);
		f.setStd(Date.from(Instant.now().plus(new Random().nextInt(300), ChronoUnit.HOURS)));
		f.setSta(Date.from(f.getStd().toInstant().plus(new Random().nextInt(800), ChronoUnit.MINUTES)));
		return f;
	}
}
