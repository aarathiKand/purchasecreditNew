# purchasecredit
 
  Added Controller , Service, View Models to match the requirements in the code
  
  1. PurchaseCreditController --> has a Post method to be called from PostMan or UI
  2. Business Logic is in the --->CreditingServiceImpl
  
  code created: Aarathi Kandregula


PostMan parameters to be called

method : Post
url:http://localhost:8080/calculateCredit
Request:{
    "CustomerPurchaseInformation": {
        "CustomerInformation": [
            {
                "customerId": "123",
                "firstMonthPurchase": [100,250,30],
                "secondMonthPurchase":[100,250,30],
                "thirdMonthPurchase": [100,250,30]
            }
        ]
    }
}
