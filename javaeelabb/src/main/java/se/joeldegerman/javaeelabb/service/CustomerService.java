package se.joeldegerman.javaeelabb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.joeldegerman.javaeelabb.dao.CustomerDao;
import se.joeldegerman.javaeelabb.entities.Address;
import se.joeldegerman.javaeelabb.entities.Customer;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;

@Stateless
public class CustomerService {

	@Inject
	private CustomerDao dao;

	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	public Customer removeCustomer(int id) throws CustomerNotFoundException {
		return dao.removeCustomer(id);
	}

	public Customer findCustomer(int id) throws CustomerNotFoundException {
		return dao.findCustomer(id);
	}

	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	public Customer updateCustomer(Customer updatedCustomer) {
		return dao.updateCustomer(updatedCustomer);
	}

	public Customer updateAddress(int customerId, Address address) throws CustomerNotFoundException {
		Customer customer = findCustomer(customerId);
		customer.setAddress(address);
		updateCustomer(customer);
		return customer;
	}

}
