package com.yy.springcloud.controller;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import com.yy.springcloud.loadbalance.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:36 2020/12/30
 *Description : 
 *Version     : 
 ***/
@RestController
@Slf4j
public class orderController {

//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private MyLB myLB;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        log.info(result.toString());
        return result;
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else return new CommonResult<>(444,"操作失败");
    }
    /**
     * 负载均衡测试
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(list==null||list.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = myLB.instance(list);

        URI uri = serviceInstance.getUri();
        return  restTemplate.getForObject(uri+"/payment/lb",String.class);

    }


}
