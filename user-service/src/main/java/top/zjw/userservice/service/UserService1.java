//package top.zjw.userservice.service;
//
//
//import jakarta.annotation.Resource;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//public class UserService1 {
//    @Resource
//    private DiscoveryClient discoveryClient;
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    public String queryAiModel(String question) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("cart-service");
//        if (instances.isEmpty()) {
//            throw new RuntimeException("AI 服务未注册");
//        }
//
//        String url = instances.get(0).getUri() + "/query";
//        return restTemplate.postForObject(url, question, String.class);
//    }
//    public String addToCart(String productId, int quantity) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("cart-service");
//        if (instances.isEmpty()) {
//            throw new RuntimeException("Cart service not available");
//        }
//
//        String url = instances.get(0).getUri() + "/cart/add";
//        String requestBody = String.format("{\"product_id\": \"%s\", \"quantity\": %d}", productId, quantity);
//        return restTemplate.postForObject(url, requestBody, String.class);
//    }
//
//    public String getCart() {
//        List<ServiceInstance> instances = discoveryClient.getInstances("cart-service");
//        if (instances.isEmpty()) {
//            throw new RuntimeException("Cart service not available");
//        }
//
//        String url = instances.get(0).getUri() + "/cart";
//        return restTemplate.getForObject(url, String.class);
//    }
//}