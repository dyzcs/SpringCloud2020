package com.deng.mscloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/3/14.
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_OK,";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
