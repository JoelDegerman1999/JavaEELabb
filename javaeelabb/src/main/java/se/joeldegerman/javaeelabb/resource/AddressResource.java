package se.joeldegerman.javaeelabb.resource;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import se.joeldegerman.javaeelabb.entities.Address;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;
import se.joeldegerman.javaeelabb.service.AddressService;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

	@Inject
	private AddressService addressService;

	@POST
	public Address addAddress(Address address, @PathParam("customerId") int id) throws CustomerNotFoundException {
		return addressService.addAddress(address, id);
	}

	@PUT
	public Address updateAddress(@PathParam("customerId") int customerId, Address address) throws CustomerNotFoundException {
		return addressService.updateAddress(customerId, address);
	}

	@GET
	public Address getAddress(@PathParam("customerId") int id) throws CustomerNotFoundException {
		return addressService.getAddress(id);
	}

}
