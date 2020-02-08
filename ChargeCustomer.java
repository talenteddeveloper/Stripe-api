package stripe.payment;

import java.util.*;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public class ChargeCustomer {

	public static void main(String[] args) throws StripeException {
		Stripe.apiKey ="sk_test*******";
    Map<String, Object> params = new HashMap<>();
		params.put("amount", 3000);
		params.put("currency", "usd");
		params.put("customer", "cus_DTN7GkeFdnvEDb");

		Charge charge = Charge.create(params);
		System.out.println(charge);
	}

}
