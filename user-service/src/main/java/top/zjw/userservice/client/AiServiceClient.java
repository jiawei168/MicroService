//package top.zjw.userservice.client;
//
//
//import jakarta.annotation.Resource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class AiServiceClient {
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    public String queryAI(String question) {
//        // 使用负载均衡调用 ai-service
//        return restTemplate.postForObject("http://ai-service/query", question, String.class);
//    }
//}