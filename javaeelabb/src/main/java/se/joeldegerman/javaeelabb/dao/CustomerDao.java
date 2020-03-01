package se.joeldegerman.javaeelabb.dao;

import java.util.List;

import se.joeldegerman.javaeelabb.entities.Customer;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;

public interface CustomerDao {

	Customer addCustomer(Customer customer);

	Customer findCustomer(int id) throws CustomerNotFoundException;

	List<Customer> getCustomers();

	Customer removeCustomer(int id) throws CustomerNotFoundException;
	
	Customer updateCustomer(Customer customer);

}
