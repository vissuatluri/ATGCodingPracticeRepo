package com.java.controller;

import com.java.dao.CustomerProductDAO;
import com.java.dto.CustomerProduct;

public class CustomerProductController {

	public void addCustomerProduct(CustomerProduct cp)
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.addCustomerProduct(cp);
	}
	
	public void deleteCustomerProduct(CustomerProduct cp)
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.deleteCustomerProduct(cp);
	}
	
	public void getEmailScheduleDetails()
	{
		CustomerProductDAO dao = new CustomerProductDAO();
		
		dao.getEmailScheduleDetails();
	}
}

