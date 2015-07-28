package com.github.kjit.jpap.services;

import java.util.ArrayList;

import com.github.kjit.jpap.model.Flight;
import com.github.kjit.jpap.model.FlightList;

public class FlightsServices {
	public FlightList getFlights() {
		FlightList flights = new FlightList();
		flights.setFlights(new ArrayList<Flight>());
		flights.getFlights().add(mockFlight("Gdansk", "Gdynia"));
		return flights;
	}

	private Flight mockFlight(String string, String string2) {
		Flight flight = new Flight();
		flight.setDeparture(string);
		flight.setDestination(string2);

		return flight;
	}
}
