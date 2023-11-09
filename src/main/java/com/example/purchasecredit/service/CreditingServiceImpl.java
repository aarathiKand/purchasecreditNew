package com.example.purchasecredit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.purchasecredit.viewmodel.CalculatedPurchaseCredits;
import com.example.purchasecredit.viewmodel.CustomerInformation;
import com.example.purchasecredit.viewmodel.CustomerPurchaseInformation;

@Service
public class CreditingServiceImpl implements CreditingService {

	public List<CalculatedPurchaseCredits> calculateCredit(CustomerPurchaseInformation information) {
		List<CalculatedPurchaseCredits> customerConsolidatedCreditList = new ArrayList<CalculatedPurchaseCredits>();
		for (CustomerInformation custinfo : information.getCustomerInformation()) {
			CalculatedPurchaseCredits newCreditinfo = new CalculatedPurchaseCredits();

			newCreditinfo.setCustomerId(custinfo.getCustomerId());

			Map<Integer, Integer> monthtoCreditMap = new HashMap<Integer, Integer>();
			int firstMonthCredit = getCredits(custinfo.getFirstMonthPurchase());
			int secondMonthCredit = getCredits(custinfo.getFirstMonthPurchase());
			int thirdMonthCredit = getCredits(custinfo.getFirstMonthPurchase());
			int totalcredits = firstMonthCredit + secondMonthCredit + thirdMonthCredit;

			monthtoCreditMap.put(1, Integer.valueOf(firstMonthCredit));
			monthtoCreditMap.put(2, Integer.valueOf(secondMonthCredit));
			monthtoCreditMap.put(3, Integer.valueOf(thirdMonthCredit));
			newCreditinfo.setMonthtoCreditsMap(monthtoCreditMap);
			newCreditinfo.setTotalCredits(Integer.valueOf(totalcredits));
			customerConsolidatedCreditList.add(newCreditinfo);
		}
		return customerConsolidatedCreditList;

	}

	private int getCredits(List<Integer> monthPurchases) {
		int creditsFor50 = 0;
		int creditsFor100 = 0;
		for (Integer purchase : monthPurchases) {
			if (null != purchase && purchase.intValue() > 50) {
				creditsFor50 = purchase.intValue() % 50;
				creditsFor100 = purchase.intValue() % 100;
			}
		}

		return creditsFor50 + creditsFor100;
	}

}
