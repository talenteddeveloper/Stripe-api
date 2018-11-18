		Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	//add stripe key
    	Stripe.apiKey ="***********8";
    	
    	//change customer id
        Customer newCustomer = Customer.retrieve("cus_Dzq22K6BkmYEcU");
        ExternalAccountCollection allCardDetails = newCustomer.getSources();
        
        Map < String, Object> cardParam = new HashMap< String, Object> ();
        cardParam.put("number", "4111111111111111");
        cardParam.put("exp_month", "11");
        cardParam.put("exp_year", "2026");
        cardParam.put("cvc", "123");
        
        Map < String, Object> tokenParam = new HashMap< String, Object> ();
        tokenParam.put("card", cardParam);
        
        Token token =Token.create(tokenParam);
        Boolean cardIsNotExist =true;
        for(int i=0; i<allCardDetails.getData().size();i++)
        {
        	String a= allCardDetails.getData().get(i).toJson();
        	Card card = gson.fromJson(a, Card.class);
        	if(card.getFingerprint().equals(token.getCard().getFingerprint()))
        	{
        		cardIsNotExist = false;
        	}
        }
        if(cardIsNotExist)
        {
        	 Map < String, Object> source = new HashMap< String, Object> ();
             source.put("source",token.getId());
             
             newCustomer.getSources().create(source);
             System.out.println("card created");
        }
        else
        {
        	System.out.println("card already exist");
        }
        
       
       System.out.println( gson.toJson(newCustomer));
      
        
