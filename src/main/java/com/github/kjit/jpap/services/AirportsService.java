package com.github.kjit.jpap.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kjit.jpap.dao.AirportDao;
import com.github.kjit.jpap.model.Airport;

@Stateless
public class AirportsService {

	private static final Logger LOG = LoggerFactory.getLogger(AirportsService.class);
	
	@EJB
	AirportDao airportDao;
	
	public void uploadDataFromFile(String path) throws IOException {
		try(BufferedReader csvFileReader = new BufferedReader(new FileReader(path))) {
		LOG.debug("Reading: "+path);
		String line = null;
			while ((line = csvFileReader.readLine()) != null) {
				Airport airport = parseToAirport(line);
				if (airport != null) {
					LOG.debug("Adding: {}", airport);
					airportDao.addAirport(airport);
				}
				
			}
		};
		
	}

	private Airport parseToAirport(String line) {
		String[] elements = line.split(",");
		Airport a = new Airport();
		a.setFullName(elements[1].replace('"', ' ').trim() + " " + elements[2].replace('"', ' ').trim());
		a.setIata(elements[4].replace('"', ' ').trim());
		a.setIcao(elements[5].replace('"', ' ').trim());
		if (a.getIcao() == null) {
			LOG.debug("No icao in {} ", line);
			return null;
		}
		String sLat = elements[6];
		if (sLat != null) {
			a.setLatitude(new BigDecimal(sLat));
		}
		String sLong = elements[7];
		if (sLong != null) {
			a.setLongitude(new BigDecimal(sLong));
		}
		
		return a;
	}
	
}
