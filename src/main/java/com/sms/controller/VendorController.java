package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("Called");
		List<Vendor> listOfVendors = vendorService.getAllVendors();
		return listOfVendors;
	}
	
}
