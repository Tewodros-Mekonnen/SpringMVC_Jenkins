package com.tewodros_mekonnen.springdemo.service;

import java.util.List;

import com.tewodros_mekonnen.springdemo.entity.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer newCustomer);

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

	

}
