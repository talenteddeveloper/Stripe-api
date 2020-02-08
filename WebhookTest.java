

import java.util.*;

import com.stripe.*;
import com.stripe.exception.StripeException;
import com.stripe.model.WebhookEndpoint;


public class WebhookTest {

	public static void main(String[] args) throws StripeException {
		
    	Stripe.apiKey ="sk_test_*******"; //add your api key
    	List<Object> events = new ArrayList<Object>();
    	events.add("charge.succeeded");
    	events.add("charge.failed");
    	
    	Map<String, Object> param = new HashMap<String, Object>();
    	param.put("enabled_events",events);
    	param.put("url", "https://webhook.site/6771f998-390c-4963-a821-e40289dfcac0");
    	
    	WebhookEndpoint weEndpoint = WebhookEndpoint.create(param);
    	System.out.println(weEndpoint);
	}

}
