package com.galvanize.assessment.newzorktimes;

import com.galvanize.assessment.newzorktimes.Controller.PaymentController;
import com.galvanize.assessment.newzorktimes.service.PaymentService;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewzorktimesApplicationTests {

	private final static Logger slf4jLogger = LoggerFactory.getLogger(NewzorktimesApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	/*curl https://api.stripe.com/v1/charges \
   -u sk_test_4eC39HqLyjWDarjtT1zdp7dc: \
   -d amount=2000 \
   -d currency=usd \
   -d source=tok_visa \
   -d description="Charge for jenny.rosen@example.com"
	* */

	//creating wiremock to mock the Stripe API
	@ClassRule
	public static WireMockClassRule wireMockClassRule = new WireMockClassRule(1234);
	@Rule
	public WireMockClassRule wireMockRule = wireMockClassRule;


	//testing REST call
	@Test
	public void testDummyStripe(){

		PaymentController paymentController = null;

		wireMockRule.stubFor(post(urlEqualTo("/stripe"))
				.withHeader("Accept",equalTo("application/json"))
				.willReturn(aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody("{"+
										"'payment_success':'true'"+
										"}</response>")));

		try{
			paymentController.processPayment();
		}catch (Exception e){
			slf4jLogger.error("failed to send data .....  " +e);
		}


	}
}

