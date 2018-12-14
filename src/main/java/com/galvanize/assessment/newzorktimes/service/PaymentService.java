package com.galvanize.assessment.newzorktimes.service;

import com.galvanize.assessment.newzorktimes.model.Payment;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


@Service
public class PaymentService {

    private final Payment payment;


    private final static Logger slf4jLogger = LoggerFactory.getLogger(PaymentService.class);

    public PaymentService(Payment payment) {
        this.payment = payment;
    }


    public void sendPayment(){

        try {

        HttpPost httpPost = new HttpPost("https://api.stripe.com/v1/charges");
        HttpClient httpClient = HttpClients.createMinimal();

        //setting some static data
        payment.setAmount("45.00");
        payment.setCurrency("USD");
        payment.setDesciption("Just..one of those things!!");
        payment.setSource("Mars Platinum Card");

        //sending data
        final NameValuePair[] data = {
                new BasicNameValuePair("amount", payment.getAmount()),
                new BasicNameValuePair("currency", payment.getCurrency()),
                new BasicNameValuePair("source", payment.getSource()),
                new BasicNameValuePair("description", payment.getDesciption())
        };


            httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));

            slf4jLogger.info("sending data to the external service --this message is from service class.....");
            HttpResponse httpResponse = httpClient.execute(httpPost);

            //getting response back
            String responseString = EntityUtils.toString(httpResponse.getEntity());
            slf4jLogger.info("Here is the response from the payment service : "+responseString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
