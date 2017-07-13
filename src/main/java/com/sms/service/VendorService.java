package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.model.Vendor;
import com.sms.repository.VendorRepository;

@Service("vendorService")
public class VendorService {

	@Autowired
	VendorRepository vendorRepository;
	
	@Transactional
	public List<Vendor> getAllVendors() {
		return vendorRepository.getAllVendors();
	}
	
	@Transactional
	public Vendor getVendor(long id) {
		return vendorRepository.getVendor(id);
	}
	
	@Transactional
	public void addVendor(Vendor vendor) {
		vendorRepository.addVendor(vendor);
	}
	
	@Transactional
	public void updateVendor(Vendor vendor) {
		vendorRepository.updateVendor(vendor);
	}
}
