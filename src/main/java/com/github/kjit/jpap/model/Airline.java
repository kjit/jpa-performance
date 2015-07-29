package com.github.kjit.jpap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the airlines database table.
 * 
 */
@Entity
@Table(name="airlines")
@NamedQuery(name="Airline.findAll", query="SELECT a FROM Airline a")
public class Airline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="airlines_id_seq",sequenceName="airlines_id_seq")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=6)
	private String code;

	@Column(length=512)
	private String name;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="airline")
	private List<Flight> flights;

	public Airline() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setAirline(this);

		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setAirline(null);

		return flight;
	}

}