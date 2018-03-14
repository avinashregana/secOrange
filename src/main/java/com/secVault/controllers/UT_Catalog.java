/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.secVault.controllers;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.secVault.entities.AddressEntity;
import com.secVault.entities.SecAccountsEntity;
import com.secVault.repository.Repository;

// Configure using Spring's testing integration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/configuration/applicationContext.xml")
public class UT_Catalog {
    
    @Autowired
    private Repository repository;
    
	@Test
	public void catalogTest() {
		assertTrue("spring container should not be null", repository != null);
		
		
		//List<SecAccountsEntity> secAccountsList = repository.fetchAllSecAccount();
	//	System.out.println("SEcAcconts size : " + secAccountsList.size());
		System.out.println("In test case");
		repository.insertAccount(createSecValutAcct());
		
		//printSecAccounts();
		
	}
	
	public void testJsonFormat() {
		
	}
	
	private SecAccountsEntity createSecValutAcct() {
		
		SecAccountsEntity secAcctEntity = new SecAccountsEntity();
		
		//secAcctEntity.setId(325);
		secAcctEntity.setAccountUserName("harsha");
		secAcctEntity.setAccountPassword("12345678");
		secAcctEntity.setCompanyName("google");
		secAcctEntity.setCompanyUrl("google.com");
		secAcctEntity.setAccountEmail("hr@google.com");
		secAcctEntity.setCountry("United States");	
		secAcctEntity.setCustomerUserName("harsha0919");
		
		
		AddressEntity addrEntity = new AddressEntity();
		addrEntity.setAddr_line1("3600 uhcl Hawk blvd");
		//addrEntity.setAddr_line2("");
		addrEntity.setCity("Fremont");
		addrEntity.setState("CA");
		addrEntity.setZip(77058);
		addrEntity.setCountry("USA");
		
		secAcctEntity.setAddressEntity(addrEntity);
		
		return secAcctEntity;
		
	}
	
	private void printSecAccounts() {
		
		List<SecAccountsEntity> secAcctEntityList = repository.fetchAllSecAccount("harsha");
		
		for(SecAccountsEntity  secAcct : secAcctEntityList) {
			
			System.out.println("USerNanme: " + secAcct.getAccountUserName());
			AddressEntity entity = secAcct.getAddressEntity();
			if(entity != null) {
				System.out.println("Address : " + secAcct.getAddressEntity().getAddr_line1() + " , " + secAcct.getAddressEntity().getAddr_line2() + ", " + secAcct.getAddressEntity().getCity());
			} else {
				System.out.println("Lazy intitialization suxcess!!! and value ofr Address is : " + secAcct.getAddressEntity());
			}
		}
		
	}
 
}
