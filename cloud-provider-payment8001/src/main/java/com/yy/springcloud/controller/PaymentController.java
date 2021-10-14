package com.yy.springcloud.controller;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import com.yy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 15:11 2020/12/24
 *Description : 
 *Version     : 
 ***/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果*******"+result+":"+payment.getSerial());
        if(result>0){
            return new CommonResult(200,"插入成功:"+serverPort);
        }
        else {
            return new CommonResult(404,"插入失败:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id ){
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果*******"+result+"455425456");
        if(result!=null){
            return new CommonResult(200,"查询成功:"+serverPort);
        }
        else {
            return new CommonResult(404,"查询失败,:"+serverPort,id);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> service = discoveryClient.getServices();
        for (String element : service) {
            log.info("******element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 负载均衡测试
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping( value ="/payment/zipkin")
    public String paymentZipkin(){
        return "zipKin server fall back****************";
    }

}
