package com.codeforchangeskill.PaymentService.service;


import com.codeforchangeskill.PaymentService.entity.TransactionDetail;
import com.codeforchangeskill.PaymentService.model.PaymentMode;
import com.codeforchangeskill.PaymentService.model.PaymentRequest;
import com.codeforchangeskill.PaymentService.model.PaymentResponse;
import com.codeforchangeskill.PaymentService.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest)
    {
        log.info("Payment Details initiated ;{}",paymentRequest);

    TransactionDetail transactionDetail
            =TransactionDetail.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

    transactionDetailsRepository.save(transactionDetail);
    log.info("Transaction completed with Id: {} ",transactionDetail.getId());

    return transactionDetail.getId();

    }

    @Override
    public PaymentResponse getPaymentDetailsByOrder(String orderId) {

     log.info("Getting Payment details for the given order id ;{}",orderId);
     TransactionDetail transactionDetail
             =transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));

        PaymentResponse paymentResponse
                =PaymentResponse.builder()
                .paymentId(transactionDetail.getId())
                .status(transactionDetail.getPaymentStatus())
                .paymentMode(PaymentMode.valueOf(transactionDetail.getPaymentMode()))
                .paymentDate(transactionDetail.getPaymentDate())
                .amount(transactionDetail.getAmount())
                .orderId(transactionDetail.getOrderId())
                .build();

        return paymentResponse;

    }
}
