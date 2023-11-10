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

Added image Link to be used to Call in Postman


![image](https://github.com/aarathiKand/purchasecreditNew/assets/150388953/4dc364b6-ee94-414a-ab3c-35c787d69a3f)
