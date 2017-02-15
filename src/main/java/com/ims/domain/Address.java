package com.ims.domain;

import javax.persistence.*;

@Entity
@Table(name="ims_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="addressSeq")
	@SequenceGenerator(allocationSize=1, name="addressSeq", sequenceName="ADDR_SEQ")	
	@Column(name="a_id")
	private int id;
	
	@Column(name="a_street")
	private String street;
	
	@Column(name="a_city")
	private String city;
	
	@Column(name="a_state")
	private String state;
	
	@Column(name="a_zip")
	private String zip;

	public Address(){}
	
	public Address(String street, String city, String state, String zip) {
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}

	@Override
	public String toString() {
		return "[street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
