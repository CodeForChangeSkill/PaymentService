package com.codeforchangeskill.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {

    private long paymentId;
    private String paymentStatus;
    private PaymentMode paymentMode;
    private Instant paymentDate;
    private long amount;
    private long orderId;
}
