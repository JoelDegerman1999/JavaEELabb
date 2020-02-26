package se.joeldegerman.javaeelabb.dao;

import java.util.List;

import se.joeldegerman.javaeelabb.entities.Customer;

public interface CustomerDao {

	Customer addCustomer(Customer customer);

	Customer findCustomer(int id);

	List<Customer> getCustomers();

	Customer removeCustomer(int id);
	
	Customer updateCustomer(Customer customer);

}
