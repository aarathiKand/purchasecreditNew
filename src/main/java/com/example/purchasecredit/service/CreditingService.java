package com.example.purchasecredit.service;

import java.util.List;

import com.example.purchasecredit.viewmodel.CalculatedPurchaseCredits;
import com.example.purchasecredit.viewmodel.CustomerPurchaseInformation;

public interface CreditingService {

	public List<CalculatedPurchaseCredits> calculateCredit(CustomerPurchaseInformation information);
}
