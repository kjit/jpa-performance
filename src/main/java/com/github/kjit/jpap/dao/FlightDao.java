package com.github.kjit.jpap.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.model.Flight;

@Stateless
public class FlightDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(FlightDao.class);
	
	@PersistenceContext(unitName="flightPU")
	EntityManager em;

	public List<Flight> getFlights() {
		LOG.info("Call for Flights");
		
		//return em.createQuery("from Flight", Flight.class).getResultList();
		return em.createNamedQuery("Flight.findAll", Flight.class).getResultList();
	}
	
}
