package se.joeldegerman.javaeelabb.resource;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import se.joeldegerman.javaeelabb.entities.Customer;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;
import se.joeldegerman.javaeelabb.service.CustomerService;

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
	
	@Inject
	private CustomerService customerService;
	
	@Context
	private ResourceContext resourceContext;

	@GET
	@Path("{id}")
	public Customer getCustomer(@PathParam("id") int id) throws CustomerNotFoundException {
		return customerService.findCustomer(id);
	}
	
	@GET
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@POST
	public Customer addCustomer(Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@DELETE
	@Path("{id}")
	public Customer deleteCustomer(@PathParam("id") int id) throws CustomerNotFoundException {
		return customerService.removeCustomer(id);
	}
	
	@PUT
	@Path("{id}")
	public Customer updateCustomer(Customer customer, @PathParam("id") int id) {
		customer.setId(id);
		return customerService.updateCustomer(customer);
	}
	
	@Path("{customerId}" + "/address")
	public AddressResource getAddressResource() {
		return resourceContext.getResource(AddressResource.class);
	}
	
	
}
