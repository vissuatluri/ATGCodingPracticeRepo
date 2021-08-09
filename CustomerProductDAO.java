package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import com.java.dto.CustomerProduct;
import com.java.dto.Product;

public class CustomerProductDAO {
	
	public void addProduct(Product p)
	{
		String sql = "INSERT INTO Product (productName) VALUES (?)";
		Connection con = getDBConnection() ;
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, p.getName());
		try {
			int productAdded = statement.executeUpdate();
			if (productAdded > 0) {
			    System.out.println("A new Product added successfully!");
			}
		}catch(SQLException ex) {
			con.close();
			System.out.println("Exception occured while adding Product. Kindly verify the details"+ex.getMessage());
		}
		
		

	}
	public void addCustomerProduct(CustomerProduct cp)
	{
		String sql = "INSERT INTO CustomerProduct (customerId, productName, domain, durationMonths,startDate) VALUES (?, ?, ?, ?,?)";
		Connection con = getDBConnection() ;
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, cp.getCustomerId());
		statement.setString(2, cp.getProductName());
		statement.setString(3, cp.getDomain());
		statement.setString(4, cp.getDurationMonths());
		statement.setDate(5, cp.getStartDate());
		try {
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new Customer Product added successfully!");
		}}catch(SQLException ex) {
			con.close();
			System.out.println("Exception occured while adding CustomerProduct. Kindly verify the details"+ex.getMessage());
		}
		
	}
	
	public void deleteCustomerProduct(CustomerProduct cp)
	{
		String sql = "DELETE FROM CustomerProduct WHERE customerId=? and productName = ? and domain = ?";
		Connection con = getDBConnection() ;
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, cp.getCustomerId());
		statement.setString(2, cp.getProductName());
		statement.setString(3, cp.getDomain());
		try {
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A Customer record was deleted successfully!");
		}
		else {
			System.out.println("No data found with the provided details");
		}}catch(SQLException ex) {
			con.close();
			System.out.println("Exception occured while deleting CustomerProduct. Kindly verify the details"+ex.getMessage());
		}
	}
	
	public List<CustomerProduct> getEmailScheduleDetails()
	{
		String sql = "SELECT * FROM CustomerProduct";
		List<CustomerProduct> emailDetailsList = new ArrayList<CustomerProduct>();
		List<Date> emailDetails = new ArrayList<Date>();
		 
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		 
		while (result.next())
		{
			String custId = result.getString(1);
			String productName = result.getString(2);
			String domain = result.getString(3);
			int duration = result.getString(4);
			Date startDate = result.getDate(5);
			emailDetails = getEmailSchedule(custId,productName,domain,duration,startDate);
			for( Date emailDate: emailDetails)
			{
				
				  CustomerProduct cp = new CustomerProduct();
				  cp.setCustomerId(custId); 
				  cp.setProductName(productName);
				  cp.setDomain(domain); 
				  cp.setEmailDate(emailDate);
				  emailDetailsList.add(cp);
			}
		}
		emailDetailsList.sort(Comparator.comparing(CustomerProduct::getEmailDate));
		return emailDetailsList;
	}
	
	

	
	public List<Date> getEmailSchedule(String custId,String productName,String domain,int durationMonths,Date startDate)
	{
		List<Date> emailDetails = new ArrayList<Date>();
		 if(productName.equalsIgnoreCase("Domain"))
			{
				//c.add(Calendar.DATE, -2);
				emailDetails.add(getEmailDate(startDate, durationMonths, -2,true));
			}
		 else if(productName.equalsIgnoreCase("Hosting"))
		 {
			 emailDetails.add(getEmailDate(startDate, durationMonths, -3,true));
			 emailDetails.add(getEmailDate(startDate, durationMonths, 1,false));
		 }
		 else if(productName.equalsIgnoreCase("pdomain"))
		 {
			 emailDetails.add(getEmailDate(startDate, durationMonths, -9,true));
			 emailDetails.add(getEmailDate(startDate, durationMonths, -2,false));
		 }
		return emailDetails;
	}
	
	public Date getEmailDate(Date startDate,int durationMonths, int days, boolean expiryFlag)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		if(expiryFlag) {
		c.add(Calendar.MONTH, durationMonths);
		}
		c.add(Calendar.DATE, days);
		return c.getTime();
	}
	
	private Connection getDBConnection()
	{		
	  Connection con = null;
	  String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	  String username = "vissu";
	  String password = "secret";
	   
	  try {
	   
	      Connection conn = DriverManager.getConnection(dbURL, username, password);
	   
	      if (conn != null) {
	          System.out.println("Connected");
	      }
	  } catch (SQLException ex) {
	      ex.printStackTrace();
	     
}
	  return con;
		
	
}