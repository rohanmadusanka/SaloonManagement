package com.sms.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	public void addVendor(Vendor vendor){
		Session session = this.sessionFactory.getCurrentSession();
		session.save(vendor);
		session.getTransaction().commit();
	}
	
	public Vendor getVendor(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor vendor = (Vendor) session.createQuery("from Vendor where id=:id").setParameter("id", id).uniqueResult();
		return vendor;
	}
	
	public void updateVendor(Vendor vendor){
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		session.update(vendor);
		tr.commit();
//		session.createQuery("update Vender v set v.vendorName=:name where id=:id").setParameter("id", vendor.getId()).setParameter("name", vendor.getVendorName());
		
	}
}
