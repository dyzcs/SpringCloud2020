package com.deng.mscloud.service;

import com.deng.mscloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2020/3/6.
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
