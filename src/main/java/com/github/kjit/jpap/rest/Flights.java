package com.github.kjit.jpap.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.model.FlightList;
import com.github.kjit.jpap.services.FlightsService;

@Path("flights")
public class Flights {

	private static final Logger LOG = LoggerFactory.getLogger(Flights.class);
	
	@EJB
	FlightsService flightService;
	
	
	@GET
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public FlightList getFlights() {
		LOG.info("Get Flights");
		return flightService.getFlights();
	}
	
	
}
