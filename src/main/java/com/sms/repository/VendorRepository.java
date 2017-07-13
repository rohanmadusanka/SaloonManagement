package com.sms.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.model.Vendor;

@Repository
public class VendorRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Vendor> getAllVendors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vendor> vendorList = session.createQuery("from Vendor").list();
		return vendorList;
	}
	
	
}
