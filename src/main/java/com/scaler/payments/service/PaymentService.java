package com.scaler.payments.service;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String createPaymentLink(String orderId, Long amount) throws StripeException;
}
