package com.codeforchangeskill.PaymentService.controller;


import brave.Response;
import com.codeforchangeskill.PaymentService.model.PaymentRequest;
import com.codeforchangeskill.PaymentService.model.PaymentResponse;
import com.codeforchangeskill.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){

        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.OK
        );
    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrder(@PathVariable long orderId)
    {
        PaymentResponse paymentResponse
                =paymentService.getPaymentDetailsByOrder(orderId);

        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);

}}

