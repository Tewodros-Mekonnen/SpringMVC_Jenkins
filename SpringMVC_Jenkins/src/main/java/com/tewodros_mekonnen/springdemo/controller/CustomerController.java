package com.tewodros_mekonnen.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tewodros_mekonnen.springdemo.entity.Customer;
import com.tewodros_mekonnen.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showFormToAddCustomers")
	public String showFormTOAddCustomers(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer); // "customer" == modelattribute inside add-customer.jsp

		return "add-customers";
	}
	
	@PostMapping("/saveCustomer") // "/saveCustomer" == action attribute inside add-customer.jsp
	public String saveCustomer(@ModelAttribute("customer") Customer newCustomer) {
		
		// save the customer using service
		customerService.saveCustomer(newCustomer);
		
		return "redirect:/customers/showFormToAddCustomers";
	}
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer from the Service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set the customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer); // "customer" == modelAttribute @add-customers.jsp
		
		// send over to form
		return "add-customers";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		//search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	

}
