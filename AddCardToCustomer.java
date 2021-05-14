

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.Token;

public class AddCardToCustomer {
	public static void main(String[] args) throws StripeException {
		

		// add stripe key
		Stripe.apiKey = "*****"; 

		Customer customer = Customer.retrieve("cus_JPujXXXX"); //add customer id here : it will start with cus_
		Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
		cardParam.put("number", "4111111111111111");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2026");
		cardParam.put("cvc", "123");

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam); // create a token

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId()); //add token as source

		Card card = (Card)customer.getSources().create(source); // add the customer details to which card is need to link
		String cardDetails = card.toJson();
		System.out.println("Card Details : " + cardDetails);
		customer = Customer.retrieve("cus_JPujEY8mNST4rf");
		System.out.println("After adding card, customer details : " + customer);
	}
}
