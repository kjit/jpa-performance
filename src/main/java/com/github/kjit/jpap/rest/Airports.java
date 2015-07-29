package com.github.kjit.jpap.rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.github.kjit.jpap.services.AirportsService;

@Path("airports")
public class Airports {

	@EJB
	AirportsService service;
	
	@PUT
	@Path("import")
	@Consumes({MediaType.APPLICATION_JSON})
	public String setupImport(String path) {
		try {
			service.uploadDataFromFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
	
}
