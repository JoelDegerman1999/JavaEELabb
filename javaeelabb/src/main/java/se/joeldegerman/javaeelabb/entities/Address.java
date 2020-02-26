package se.joeldegerman.javaeelabb.entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	private String houseNumber;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
}
