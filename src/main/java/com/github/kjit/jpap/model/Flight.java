package com.github.kjit.jpap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the flights database table.
 * 
 */
@Entity
@Table(name="flights")
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="flights_seq",sequenceName="flights_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flights_seq")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=200)
	private String code;

	@Column(nullable=false)
	private Long duration;

	@Column(nullable=false)
	private Date sta;

	@Column(nullable=false)
	private Date std;

	//bi-directional many-to-one association to Airline
	@ManyToOne
	@JoinColumn(name="airline_id", nullable=false)
	private Airline airline;

	//bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name="departure", referencedColumnName="icao", nullable=false)
	private Airport departure;

	//bi-directional many-to-one association to Airport
	@ManyToOne
	@JoinColumn(name="destination", referencedColumnName="icao", nullable=false)
	private Airport destination;

	public Flight() {
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

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public Date getStd() {
		return std;
	}

	public void setStd(Date std) {
		this.std = std;
	}

	public Airline getAirline() {
		return this.airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

}