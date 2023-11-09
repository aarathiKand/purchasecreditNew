package com.example.purchasecredit.viewmodel;

import java.util.HashMap;
import java.util.Map;

public class CalculatedPurchaseCredits {
	private String customerId;
	private Map<Integer, Integer> monthtoCreditsMap = new HashMap<Integer, Integer>();
	private Integer totalCredits;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, Integer> getMonthtoCreditsMap() {
		return monthtoCreditsMap;
	}

	public void setMonthtoCreditsMap(Map<Integer, Integer> monthtoCreditsMap) {
		this.monthtoCreditsMap = monthtoCreditsMap;
	}

	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

}
