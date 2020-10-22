package com.tewodros_mekonnen.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tewodros_mekonnen.springdemo.dao.CustomerDAO;
import com.tewodros_mekonnen.springdemo.entity.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void saveCustomer(Customer newCustomer) {
		
		customerDAO.saveCustomer(newCustomer);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDAO.searchCustomers(theSearchName);
	}

	

}
