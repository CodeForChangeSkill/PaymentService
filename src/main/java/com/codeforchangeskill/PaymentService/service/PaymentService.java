package com.codeforchangeskill.PaymentService.service;

import com.codeforchangeskill.PaymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
