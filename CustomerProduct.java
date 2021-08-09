package com.java.dto;

import java.util.Date;

public class CustomerProduct {
	public String customerId;
	public String productName;
	public String domain;
	public int durationMonths;
	public Date startDate;
	public Date emailDate;	
	
	public CustomerProduct() {
		super();
	}
	
	public CustomerProduct(String customerId, String productName, String domain, int durationMonths, Date startDate) {
		super();
		this.customerId = customerId;
		this.productName = productName;
		this.domain = domain;
		this.durationMonths = durationMonths;
		this.startDate = startDate;
	}

	public CustomerProduct(String customerId, String productName, String domain) {
		super();
		this.customerId = customerId;
		this.productName = productName;
		this.domain = domain;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getDurationMonths() {
		return durationMonths;
	}
	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEmailDate() {
		return emailDate;
	}

	public void setEmailDate(Date emailDate) {
		this.emailDate = emailDate;
	}

	@Override
	public String toString() {
		return "CustomerProduct [customerId=" + customerId + ", productName=" + productName + ", domain=" + domain
				+ ", emailDate=" + emailDate + "]";
	}

		

}
