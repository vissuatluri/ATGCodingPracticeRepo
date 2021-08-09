package com.java.controller;

import com.java.dao.CustomerProductDAO;
import com.java.dto.CustomerProduct;

public class CustomerProductController {

	/**
	    * Method to add the Customer Product Info
	    *
	    * @param CustomerProduct
	    */
	public void addCustomerProduct(CustomerProduct cp)
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.addCustomerProduct(cp);
	}
	
	/**
	    * Method to delete the Customer Product 
	    *
	    * @param CustomerProduct
	    */
	public void deleteCustomerProduct(CustomerProduct cp)
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.deleteCustomerProduct(cp);
	}
	
	/**
	    * Method to list the scheduled email details(sorted by date)
	    *
	    * @return returns a list of scheduled email (sorted by date)
	    */
	public void getEmailScheduleDetails()
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.getEmailScheduleDetails();
	}
}

