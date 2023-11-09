package com.example.purchasecredit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchasecredit.service.CreditingService;
import com.example.purchasecredit.viewmodel.CalculatedPurchaseCredits;
import com.example.purchasecredit.viewmodel.CustomerPurchaseInformation;

@RestController
public class PurchaseCreditController {
	
	
	@Autowired
	CreditingService service;
	
	@PostMapping( value = "/calculateCredit", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<CalculatedPurchaseCredits>> createPerson(@RequestBody CustomerPurchaseInformation info) {
		
		if(info==null)
		{
			 return  new ResponseEntity<List<CalculatedPurchaseCredits>>(HttpStatus.BAD_REQUEST);
		}
		 
		 return  new ResponseEntity<List<CalculatedPurchaseCredits>>(service.calculateCredit(info),HttpStatus.ACCEPTED);
		
	}

}
