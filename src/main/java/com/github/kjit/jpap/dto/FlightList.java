package com.github.kjit.jpap.dto;

import java.util.ArrayList;
import java.util.List;

public class FlightList {

	private List<FlightDto> flights;

	public List<FlightDto> getFlights() {
		if (flights == null) {
			flights = new ArrayList<>();
		}
		return flights;
	}

	public void setFlights(List<FlightDto> flights) {
		this.flights = flights;
	}
	
	
}
