package com.github.kjit.jpap.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.model.Airport;
import com.github.kjit.jpap.model.Flight;

@Stateless
public class AirportDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(AirportDao.class);

	private static final String Q_EMPTY_AIRPORTS = "select a from Airport a where a.departures is empty and a.arrivals is empty";
	
	@PersistenceContext(unitName="flightPU")
	EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addAirport(Airport airport) {
		em.persist(airport);
	}

	public List<Airport> getAirportsWithoutFlights(int count) {
		return em.createQuery(Q_EMPTY_AIRPORTS, Airport.class).setMaxResults(count).getResultList();
	}

}
