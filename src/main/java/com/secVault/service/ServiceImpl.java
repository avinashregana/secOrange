package com.secVault.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;
import org.springframework.beans.factory.annotation.Autowired;
import com.secVault.entities.AddressEntity;
import com.secVault.entities.CustomerEntity;
import com.secVault.entities.SecAccountsEntity;
import com.secVault.modal.AddressPOJO;
import com.secVault.modal.Customer;
import com.secVault.modal.SecAccounts;
import com.secVault.repository.Repository;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	Repository customerDao;
	
	@Override
	public boolean loginCustomer(String username, String password) {
		System.out.println("in  login service");
		Customer cust = customerDao.fetchCustomerByUsername(username);	
		if(cust.getUsername().equals(username) && cust.getPassword().equals(password)) {
			System.out.println("in service sucess");
			return true;		
		}
		return false;
	}

	@Override
	public boolean customerRegister(Customer cust) {
		System.out.println("in service customerRegister()");

		CustomerEntity customerEntity = new CustomerEntity();

		customerEntity.setFirstname(cust.getFirstname());
		customerEntity.setLastname(cust.getLastname());
		customerEntity.setUsername(cust.getUsername());
		customerEntity.setEmail(cust.getEmail());
		customerEntity.setGender(cust.getGender());
		customerEntity.setPassword(cust.getPassword());
		customerEntity.setSsn(cust.getSsn());
		Calendar calender = Calendar.getInstance();
		java.sql.Date createdate = new java.sql.Date(calender.getTime().getTime());
		java.sql.Date updatedate = new java.sql.Date(calender.getTime().getTime());
		java.sql.Date birth = null;
		java.util.Date birthdate;
		System.out.println("before try");

		try {
			birthdate = new SimpleDateFormat("MM/DD/YY").parse(cust.getDob());
			birth = new java.sql.Date(birthdate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerEntity.setCreatedate(createdate);
		customerEntity.setUpdateDate(updatedate);
		customerEntity.setDob(birth);
		System.out.println("after setting into entity type");
		if(customerDao.insertCustomer(customerEntity) == true) {
			return true;
		}
		return false;
	}

	@Override
	public Customer fetchCustomerByUsername(String username) {
		return null;
	}

	@Override
	public List<SecAccounts> getAccounts( String userName) {
		System.out.println("in service pogo exchange");
		List<SecAccounts> secAccountsList = new ArrayList<SecAccounts> ();
		List<SecAccountsEntity> secAccounts = customerDao.fetchAllSecAccount(userName);
		AddressPOJO addressPOJO;
		java.util.Date createdateJava =null;
		for (SecAccountsEntity var : secAccounts) 
		{ 
			SecAccounts secAccountsObject = new SecAccounts();

			secAccountsObject.setCustomerUserName(userName);        
			secAccountsObject.setAccountUserName(var.getAccountUserName());
			secAccountsObject.setAccountPassword(var.getAccountPassword());
			secAccountsObject.setCompanyName(var.getCompanyName());
			secAccountsObject.setAccountEmail(var.getAccountEmail());
			secAccountsObject.setCompanyUrl(var.getCompanyUrl());
			secAccountsObject.setId(var.getId());
			secAccountsObject.setCountry(var.getCountry());
			secAccountsObject.setCreateDate(var.getCreateDate());
			secAccountsObject.setUpdateDate(var.getUpdateDate());

			//			System.out.println("in service retrieving date from pogo object");
			//		
			//			System.out.println(secAccountsObject.getCreateDate() + "  date set to pogo");

			addressPOJO = new AddressPOJO();
			AddressEntity addressEntity = var.getAddressEntity();
			if(addressEntity != null) {
				addressPOJO.setAddr_id(var.getAddressEntity().getAddr_id());
				addressPOJO.setAddr_line1(var.getAddressEntity().getAddr_line1());
				addressPOJO.setAddr_line2(var.getAddressEntity().getAddr_line2());
				addressPOJO.setCity(var.getAddressEntity().getCity());
				addressPOJO.setCountry(var.getAddressEntity().getCountry());
				addressPOJO.setState(var.getAddressEntity().getState());
				addressPOJO.setZip(var.getAddressEntity().getZip());

				secAccountsObject.setAddressPOJO(addressPOJO);
			}
			secAccountsList.add(secAccountsObject);
		}
		return secAccountsList;
	}

	@Override
	public boolean insertAccount(SecAccounts account , String userName) {


		Calendar calender = Calendar.getInstance();
		java.sql.Date createdate = new java.sql.Date(calender.getTime().getTime());
		java.sql.Date updatedate = new java.sql.Date(calender.getTime().getTime());

		System.out.println("in service");
		SecAccountsEntity  secAccountsEntity = new SecAccountsEntity();

		secAccountsEntity.setAccountEmail(account.getAccountEmail());
		secAccountsEntity.setAccountPassword(account.getAccountPassword());
		secAccountsEntity.setAccountUserName(account.getAccountUserName());
		secAccountsEntity.setCompanyName(account.getCompanyName());
		secAccountsEntity.setCompanyUrl(account.getCompanyUrl());
		secAccountsEntity.setCountry(account.getCountry());
		secAccountsEntity.setCustomerUserName(userName);
		secAccountsEntity.setId(account.getId());
		secAccountsEntity.setCreateDate(createdate);
		secAccountsEntity.setUpdateDate(updatedate);

		customerDao.insertAccount(secAccountsEntity);

		System.out.println("in service after insert");
		return true;
	}

	@Override
	public List<SecAccountsEntity> getSearchAccounts(String key , String CustUserName) {
		
		List<SecAccountsEntity> searchList = customerDao.searchByKey(key, CustUserName);
		return searchList;
	}

	@Override
	public TreeSet<SecAccounts> accountsSortByCompany(String custUserName) {

		List<SecAccounts> beforeSort = getAccounts(custUserName);
		TreeSet<SecAccounts> aftersort = new TreeSet<SecAccounts>(new CompanySortComperator());
		
		for (SecAccounts var : beforeSort) {
			aftersort.add(var);
		}
		//System.out.println("in service after adding to treeset");
		//		for (SecAccounts var : aftersort) {
		//
		//			System.out.println(var.getCompanyName());
		//
		//		}
		return  aftersort;
	}

	@Override
	public TreeSet<SecAccounts> accountsSortByCreateDate(String custUserName) {

		System.out.println("in service before sort by date");
		List<SecAccounts> beforeSort = getAccounts(custUserName);
		TreeSet<SecAccounts> aftersort = new TreeSet<SecAccounts>();

		for (SecAccounts var : beforeSort) {
			aftersort.add(var);
		}

		return aftersort;
	}




}
