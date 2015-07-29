package com.github.kjit.jpap.services;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.github.kjit.jpap.dao.FlightDao;
import com.github.kjit.jpap.model.Flight;
import com.github.kjit.jpap.model.FlightList;

@Stateless
public class FlightsService {
	
	@EJB
	FlightDao flightDao;
	
	public FlightList getFlights() {
		FlightList flights = new FlightList();
		flights.setFlights(flightDao.getFlights());
		return flights;
	}
	
	

}
