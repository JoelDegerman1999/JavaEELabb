package se.joeldegerman.javaeelabb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.joeldegerman.javaeelabb.dao.CustomerDao;
import se.joeldegerman.javaeelabb.entities.Address;
import se.joeldegerman.javaeelabb.entities.Customer;

@Stateless
public class CustomerService {

	@Inject
	private CustomerDao dao;

	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	public Customer removeCustomer(int id) {
		return dao.removeCustomer(id);
	}

	public Customer findCustomer(int id) {
		return dao.findCustomer(id);
	}

	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	public Customer updateCustomer(Customer updatedCustomer) {
		return dao.updateCustomer(updatedCustomer);
	}

	public Address addAddress(Address address, int customerId) {
		Customer customer = findCustomer(customerId);
		customer.setAddress(address);
		updateCustomer(customer);
		return address;
	}

	public Address getAddress(int customerId) {

		Customer customer = findCustomer(customerId);
		if (customer.getAddress() == null) {
			return new Address();
		}
		return customer.getAddress();
	}
	
	public Address updateAddress(int customerId, Address address) {
		Customer customer = findCustomer(customerId);
		customer.setAddress(address);
		updateCustomer(customer);
		return address;
	}

}
