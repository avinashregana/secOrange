package com.secVault.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.secVault.entities.CustomerEntity;
import com.secVault.entities.SecAccountsEntity;
import com.secVault.modal.Customer;


@org.springframework.stereotype.Repository
@Transactional // After you enabled web application remove this annotation and copy in secviceImpl
public class RepositoryImpl implements Repository{

	private static final String DB_URL =  "jdbc:mysql://localhost:3306/sec_vault?autoReconnect=true&useSSL=false";;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Connection getConnection() {
		Connection con = null;
		int i=0;
		boolean result = false;
		PreparedStatement Preparedstmt;
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			con = DriverManager.getConnection(DB_URL ,"root","root");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;		
	}

	@Override
	public boolean insertCustomer(Customer cust) {
		System.out.println("in dao ");
		int i=0;
		Connection con = getConnection();
		boolean result = false;
		Calendar calender = Calendar.getInstance();
		java.sql.Date createdate = new java.sql.Date(calender.getTime().getTime());
		java.sql.Date updatedate = new java.sql.Date(calender.getTime().getTime());
		java.sql.Date birth;
		java.util.Date birthdate;

		System.out.println("before try");
		try {			

			birthdate = new SimpleDateFormat("MM/DD/YY").parse(cust.getDob());

			birth = new java.sql.Date(birthdate.getTime());
			System.out.println(birth  + " birth");
			System.out.println("before preparred stmt in dao");
			String sql="INSERT INTO sec_vault.customer(username,firstname,lastname,gender,ssn,email,dob,password,createdate,updatedate) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement Preparedstmt = con.prepareStatement(sql);
			Preparedstmt.setString(1,cust.getUsername());
			Preparedstmt.setString(2, cust.getFirstname());
			Preparedstmt.setString(3, cust.getLastname());
			Preparedstmt.setString(4, cust.getGender());
			Preparedstmt.setString(5, cust.getSsn());
			Preparedstmt.setString(6, cust.getEmail());
			Preparedstmt.setDate(7, birth);
			Preparedstmt.setString(8, cust.getPassword());
			Preparedstmt.setDate(9, createdate);
			Preparedstmt.setDate(10, updatedate);
			i = Preparedstmt.executeUpdate();
			Preparedstmt.close();
			System.out.println("end of first prepared statement");	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1) {
			result = true;
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SecAccountsEntity> fetchAllSecAccount(String userName) {
		System.out.println("in dao accounts");
		//	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecAccountsEntity.class);
		System.out.println("in dao accounts sucess");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(SecAccountsEntity.class);
		List<SecAccountsEntity>  secAccountsList = criteria.add(Restrictions.eq("customerUserName", userName)).list();
		tx.commit();
		System.out.println("in dao after commit");
		session.close();
		return secAccountsList;

	}
	@Override
	public boolean insertAccount(SecAccountsEntity account ) {
		System.out.println("in dao");
		//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SecAccountsEntity.class);
		//		criteria.add(account);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(account);
		//System.out.println(session.save(account).getClass().getName());
		tx.commit();
		System.out.println("in dao after save");
		session.close();
		return true;
	}
	@SuppressWarnings("null")
	@Override
	public List<SecAccountsEntity> searchByKey(String key , String CustUserName) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(SecAccountsEntity.class);
		@SuppressWarnings("unchecked")
		List<SecAccountsEntity>  secAccountsListBeforeSearch = criteria.add(Restrictions.eq("customerUserName", CustUserName)).list();
		List<SecAccountsEntity>  secAccountsListAfterSearch = new ArrayList<SecAccountsEntity>();
		tx.commit();
		System.out.println("in dao after commit");
		session.close();

		for(SecAccountsEntity  var : secAccountsListBeforeSearch) {
			System.out.println(var.getCountry()+" country");
			if(var.getCountry().contains(key) || var.getAccountEmail().contains(key) || var.getAccountUserName().contains(key) ||
					var.getCompanyName().contains(key) || var.getCompanyUrl().contains(key)){

				secAccountsListAfterSearch.add(var);
			}
		}
		return secAccountsListAfterSearch;
	}


	@Override
	public boolean insertCustomer(CustomerEntity custEntity) {

		System.out.println(custEntity.getDob());

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(custEntity);
		tx.commit();
		System.out.println("in dao after saveing in customerEntity");
		session.close();

		return true;
	}
	@Override
	public Customer fetchCustomerByUsername(String username) {
		System.out.println("in dao fetchCustomerByUsername()");

		PreparedStatement Preparedstmt;
		Connection con = getConnection();
		boolean result = false;
		Customer cust = null;
		try {
			Preparedstmt = con.prepareStatement("select * from sec_vault.customer where username = ? ");
			Preparedstmt.setString(1, username);
			ResultSet rslogin = Preparedstmt.executeQuery();
			if(rslogin.next()) {
				cust = new Customer();
				cust.setFirstname(rslogin.getString("firstname"));
				cust.setLastname(rslogin.getString("lastname"));
				cust.setPassword(rslogin.getString("password"));
				cust.setUsername(rslogin.getString("username"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}
}
