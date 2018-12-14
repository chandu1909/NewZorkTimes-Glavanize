package com.galvanize.assessment.newzorktimes.Controller;

import com.galvanize.assessment.newzorktimes.model.Payment;
import com.galvanize.assessment.newzorktimes.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charge")
public class PaymentController {


    private final PaymentService paymentService;




    private final static Logger slf4jLogger = LoggerFactory.getLogger(PaymentController.class);

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/stripe")
    public void processPayment(){
        try {

            paymentService.sendPayment();

        }catch (Exception e){

            slf4jLogger.error(" Transaction failed exception raised... " +e);
        }

    }

}
