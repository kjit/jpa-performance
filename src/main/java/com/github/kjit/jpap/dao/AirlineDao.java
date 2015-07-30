package com.github.kjit.jpap.dao;

import com.github.kjit.jpap.model.Airline;
import com.github.kjit.jpap.model.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Stateless
public class AirlineDao {
	
	private static final Logger LOG = LoggerFactory.getLogger(AirlineDao.class);

	private static final String Q_EMPTY_AIRLINES = "select a from Airline a Where a.flights is empty";
	
	@PersistenceContext(unitName="flightPU")
	EntityManager em;

	public List<Airline> getAirlineWithoutFlights(int count) {
		LOG.info("Look for airlanes {}", count);
		return em.createQuery(Q_EMPTY_AIRLINES, Airline.class).setMaxResults(count).getResultList();
	}
	
}
