import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.*;
import com.stripe.exception.StripeException;
import com.stripe.model.*;

public class ListCustomers {

	public static void main(String[] args) throws StripeException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Stripe.apiKey = "Enter your stripe key";
		
		Map <String, Object> params = new HashMap<>();
		//params.put("limit",3);

		params.put("email","abc@gmail.com");
		CustomerCollection customers = Customer.list(params);
		String a = customers.toJson();
		System.out.println(a);
	}

}
