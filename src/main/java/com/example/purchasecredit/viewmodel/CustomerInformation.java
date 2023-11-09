package com.example.purchasecredit.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class CustomerInformation {
	  String customerId;
	   List<Integer> firstMonthPurchase= new ArrayList<Integer>();
	   List<Integer> secondMonthPurchase= new ArrayList<Integer>();
	   List<Integer> thirdMonthPurchase= new ArrayList<Integer>();
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getFirstMonthPurchase() {
		return firstMonthPurchase;
	}
	public void setFirstMonthPurchase(List<Integer> firstMonthPurchase) {
		this.firstMonthPurchase = firstMonthPurchase;
	}
	public List<Integer> getSecondMonthPurchase() {
		return secondMonthPurchase;
	}
	public void setSecondMonthPurchase(List<Integer> secondMonthPurchase) {
		this.secondMonthPurchase = secondMonthPurchase;
	}
	public List<Integer> getThirdMonthPurchase() {
		return thirdMonthPurchase;
	}
	public void setThirdMonthPurchase(List<Integer> thirdMonthPurchase) {
		this.thirdMonthPurchase = thirdMonthPurchase;
	}
	   
	   
}
