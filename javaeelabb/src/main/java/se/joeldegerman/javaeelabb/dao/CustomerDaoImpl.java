package se.joeldegerman.javaeelabb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.joeldegerman.javaeelabb.entities.Customer;
import se.joeldegerman.javaeelabb.exception.CustomerNotFoundException;

@Stateless
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(int id) throws CustomerNotFoundException {
		Customer customer = em.find(Customer.class, id);
		if (customer == null)
			throw new CustomerNotFoundException("Customer not found");
		em.remove(customer);
		return customer;
	}

	@Override
	public Customer findCustomer(int id) throws CustomerNotFoundException {
		Customer customer = em.find(Customer.class, id);
		if (customer == null)
			throw new CustomerNotFoundException("Customer not found");

		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		return em.createQuery("select c from Customer c", Customer.class).getResultList();
	}

	@Override
	public Customer updateCustomer(Customer updatedCustomer) {
		updatedCustomer = em.merge(updatedCustomer);
		return updatedCustomer;
	}

}
