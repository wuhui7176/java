package com.code1j.boot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
//import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import zipkin.server.EnableZipkinServer;

/**
 * @ wuhui
 * @ date  2017/9/21上午10:44
 */

@Controller
@EnableAutoConfiguration
@EnableZipkinServer
public class Main {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/")
    @ResponseBody
    Object home() {
        return "success";
    }

    @RequestMapping("/test")
    @ResponseBody
    Object test() throws InterruptedException {
        Thread.sleep(100);
        return "success";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
