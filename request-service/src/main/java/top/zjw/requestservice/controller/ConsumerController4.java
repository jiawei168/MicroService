package top.zjw.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController4 {
    @Resource
    private RestTemplate restTemplate;
    private final String SERVICE_URL = "https://www.wanandroid.com";

    @GetMapping("/restTemplateTest1")
    public String restTemplate() {
        return restTemplate.getForObject(SERVICE_URL +"/banner/json" ,String.class);
    }
}