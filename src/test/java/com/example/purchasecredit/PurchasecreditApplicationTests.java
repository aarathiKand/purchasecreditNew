package com.example.purchasecredit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.purchasecredit.controller.PurchaseCreditController;
import com.example.purchasecredit.service.CreditingService;
import com.example.purchasecredit.viewmodel.CalculatedPurchaseCredits;
import com.example.purchasecredit.viewmodel.CustomerInformation;
import com.example.purchasecredit.viewmodel.CustomerPurchaseInformation;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PurchaseCreditController.class)
@WithMockUser
class PurchasecreditApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreditingService service;

	@Test
	public void purchaseCreditTest() throws Exception {

		List<CustomerInformation> customerInfoList = new ArrayList<CustomerInformation>();
		//response
		String	exampleJson="";
		CustomerInformation custInfo = new CustomerInformation();
		custInfo.setCustomerId(null);
		custInfo.setFirstMonthPurchase(Arrays.asList(50, 30, 100));
		custInfo.setSecondMonthPurchase(Arrays.asList(50, 30, 100));
		custInfo.setThirdMonthPurchase(Arrays.asList(50, 30, 100));
		customerInfoList.add(custInfo);
		CustomerPurchaseInformation mockInformation = new CustomerPurchaseInformation(customerInfoList);

		Mockito.when(service.calculateCredit(Mockito.any(CustomerPurchaseInformation.class)))
				.thenReturn((List<CalculatedPurchaseCredits>) mockInformation);

		// Send CustomerPurchaseInformation as body to /calculateCredit
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/calculateCredit")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}

	
}
