package se.joeldegerman.javaeelabb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import se.joeldegerman.javaeelabb.entities.Customer;

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
	public Customer removeCustomer(int id) {
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
		return customer;
	}

	@Override
	public Customer findCustomer(int id) {
		return em.find(Customer.class, id);
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
