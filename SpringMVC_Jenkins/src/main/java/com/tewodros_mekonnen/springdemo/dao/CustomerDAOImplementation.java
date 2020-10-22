package com.tewodros_mekonnen.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tewodros_mekonnen.springdemo.entity.Customer;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer newCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(newCustomer);
		
	}

	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return result
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// read from the database using the primary key!
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key (id)
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate(); 
		// theQuery.executeUpdate() is a general purpose method
		
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		// only search by name, if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length()>0) {
			
			// search for firstName or lastName, case insensitive
			theQuery = currentSession.createQuery("from Customer where "
					+ "lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase()+"%");
		}
		else {
			// theSearchName is empty... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

	

	

}
