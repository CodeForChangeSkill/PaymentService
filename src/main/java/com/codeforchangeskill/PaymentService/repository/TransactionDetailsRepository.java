package com.codeforchangeskill.PaymentService.repository;

import com.codeforchangeskill.PaymentService.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetail, Long> {

    TransactionDetail findByOrderId(long orderId);
}
