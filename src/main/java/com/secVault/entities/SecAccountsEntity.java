package com.secVault.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sec_Accounts")
public class SecAccountsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
    private String companyName;
 
    @Column
    private String accountUserName;
 
    @Column
    private String accountPassword;
 
    @Column
    private String accountEmail;
    
	@Column
    private String companyUrl;
    
    @Column
    private String customerUserName;
    
    @Column
    private String country;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date createDate;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date updateDate;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AddressEntity addressEntity;
    
//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = "")
//    private CustomerEntity customerEntity;

    
    
    /**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
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
	
    /**
	 * @return the addressEntity
	 */
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	/**
	 * @param addressEntity the addressEntity to set
	 */
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}


}
