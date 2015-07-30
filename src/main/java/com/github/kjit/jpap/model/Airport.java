package com.github.kjit.jpap.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the airports database table.
 * 
 */
@Entity
@Table(name="airports")
@NamedQuery(name="Airport.findAll", query="SELECT a FROM Airport a")
public class Airport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="airports_seq",sequenceName="airports_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="airports_seq")
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="full_name", length=512)
	private String fullName;

	@Column(length=4, nullable=false)
	private String icao;
	
	@Column(length=3)
	private String iata;

	@Column(precision=16, scale=8)
	private BigDecimal latitude;

	@Column(precision=16, scale=8)
	private BigDecimal longitude;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="departure")
	private List<Flight> departures;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="destination")
	private List<Flight> arrivals;

	public Airport() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getIata() {
		return this.iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<Flight> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Flight> departures) {
		this.departures = departures;
	}

	public List<Flight> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Flight> arrivals) {
		this.arrivals = arrivals;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", fullName=" + fullName + ", icao="
				+ icao + ", iata=" + iata + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}


	
	
}