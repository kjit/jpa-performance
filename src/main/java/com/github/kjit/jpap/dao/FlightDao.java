package com.github.kjit.jpap.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.github.kjit.jpap.dto.Filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.model.Flight;

@Stateless
public class FlightDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(FlightDao.class);

	@PersistenceContext(unitName="flightPU")
	EntityManager em;

	public List<Flight> getFlights(Filters filters) {
		LOG.info("Call for Flights");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Flight> cq = cb.createQuery(Flight.class);

		Root<Flight> flightRoot = cq.from(Flight.class);
		if (filters.getDestination() != null && !filters.getDestination().isEmpty()) {
			LOG.info("Filter destination: {}", filters.getDestination());
			cq.where(cb.equal(flightRoot.get("destination").get("icao"), filters.getDestination()));
		}
		cq.select(flightRoot);

		return em.createQuery(cq).getResultList();
		//return em.createQuery("from Flight", Flight.class).getResultList();
		//return em.createNamedQuery("Flight.findAll", Flight.class).getResultList();
	}

	public void save(Flight flight) {
		em.persist(flight);
	}
}
