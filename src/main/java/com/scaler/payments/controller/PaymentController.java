package com.scaler.payments.controller;

import com.scaler.payments.dto.PaymentRequestDto;
import com.scaler.payments.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
        String paymentLink = paymentService.createPaymentLink(paymentRequestDto.getOrderId(), paymentRequestDto.getPaymentAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.CREATED);
    }

    @PostMapping("/webhook")
    public String handleWebhook() {
        System.out.println("Webhook is received");
        return "";
    }

}
