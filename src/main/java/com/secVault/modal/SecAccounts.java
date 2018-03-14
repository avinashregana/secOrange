package com.secVault.modal;

import java.util.Date;

public class SecAccounts implements Comparable<SecAccounts>{
	
	private int id;
    private String companyName;
    private String accountUserName;
    private String accountPassword; 
    private String accountEmail; 
    private String companyUrl;
    private String customerUserName;
    private String country;
    private Date createDate;
    private Date updateDate;
    
    /**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param date 
	 * @param date the createDate to set
	 */
	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	private AddressPOJO addressPOJO;
	/**
	 * @return the addressEntity
	 */
	
	/**
	 * @return the createDate
	 */
	
	public String getCountry() {
		return country;
	}
	
	/**
	 * @return the addressPOJO
	 */
	public AddressPOJO getAddressPOJO() {
		return addressPOJO;
	}
	/**
	 * @param addressPOJO the addressPOJO to set
	 */
	public void setAddressPOJO(AddressPOJO addressPOJO) {
		this.addressPOJO = addressPOJO;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the accountUserName
	 */
	public String getAccountUserName() {
		return accountUserName;
	}
	/**
	 * @param accountUserName the accountUserName to set
	 */
	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}
	/**
	 * @return the accountPassword
	 */
	public String getAccountPassword() {
		return accountPassword;
	}
	/**
	 * @param accountPassword the accountPassword to set
	 */
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	/**
	 * @return the accountEmail
	 */
	public String getAccountEmail() {
		return accountEmail;
	}
	/**
	 * @param accountEmail the accountEmail to set
	 */
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	/**
	 * @return the companyUrl
	 */
	public String getCompanyUrl() {
		return companyUrl;
	}
	/**
	 * @param companyUrl the companyUrl to set
	 */
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	/**
	 * @return the customerUserName
	 */
	public String getCustomerUserName() {
		return customerUserName;
	}
	/**
	 * @param customerUserName the customerUserName to set
	 */
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	
	

	@Override
	public int compareTo(SecAccounts o) {
		if(this.createDate!= null && o.createDate != null && !(this.createDate.equals(o.createDate))) {
		return this.createDate.compareTo(o.createDate);
		}
		return this.id - o.id ;
	}
}
