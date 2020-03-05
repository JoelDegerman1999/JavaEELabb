package se.joeldegerman.javaeelabb.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.joeldegerman.javaeelabb.entities.Address;
import se.joeldegerman.javaeelabb.entities.Customer;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;

@Stateless
public class AddressService {

	@Inject
	CustomerService customerService;

	public Address getAddress(int customerId) throws CustomerNotFoundException {

		Customer customer = customerService.findCustomer(customerId);
		if (customer.getAddress() == null) {
			return new Address();
		}
		return customer.getAddress();
	}

}
