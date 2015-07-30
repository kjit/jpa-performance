package com.github.kjit.jpap.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.kjit.jpap.dto.Filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.dto.FlightList;
import com.github.kjit.jpap.services.FlightsService;

import java.util.HashMap;
import java.util.Map;

@Path("flights")
public class Flights {

	private static final Logger LOG = LoggerFactory.getLogger(Flights.class);
	
	@EJB
	FlightsService flightService;
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public FlightList getFlights(Filters filters) {
		LOG.info("Get Flights");
		return flightService.getFlights(filters);
	}

	@POST
	@Path("/generate")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response generateFlights(Integer count ) {
		LOG.info("Generate flights");
		String info = flightService.generateFlights(count);
		Map<String, String> result = new HashMap<>();
		result.put("response", info);
		return Response.ok(result).build();
	}
}
