package com.codeforchangeskill.PaymentService.service;

import com.codeforchangeskill.PaymentService.model.PaymentRequest;
import com.codeforchangeskill.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrder(String orderId);
}
