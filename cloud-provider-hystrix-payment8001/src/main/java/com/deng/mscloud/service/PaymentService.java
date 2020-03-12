package com.deng.mscloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/9.
 */
@Service
public class PaymentService {
    /**
     * 正常访问
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_OK，id: " + id + "\t";
    }

    /**
     * 超时访问
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_TimeOut，id: " + id + "\t耗时" + timeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "系统繁忙，请稍微再试，id: " + id;
    }
}
