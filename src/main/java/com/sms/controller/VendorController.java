package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Vendor;
import com.sms.service.VendorService;


@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	
	@RequestMapping(value = "/getAllVendors", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Vendor> getVendors() {
		List<Vendor> listOfVendors = vendorService.getAllVendors();
		return listOfVendors;
	}
	
	
	
	@RequestMapping(value = "/vendor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public Vendor getVendorById(@PathVariable long id) {
	  return vendorService.getVendor(id);
	 }
	
	@RequestMapping(value = "/addVendor", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addVendor(@RequestBody Vendor vendor) {
		System.out.println(vendor.getVendorName()+"<<<<<<<<<<<<<<<<<<<<<<<<");
	  vendorService.addVendor(vendor);
	 }
	
	@RequestMapping(value = "/updateVendor", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void UpdateVendor(@RequestBody Vendor vendor) {
	  vendorService.updateVendor(vendor);
	 }
}
