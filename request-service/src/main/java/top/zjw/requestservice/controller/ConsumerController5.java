package top.zjw.requestservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ConsumerController5 {
    private final String SERVICE_URL = "https://www.wanandroid.com/article/list";

    private final WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("/webClientTest1")
    public String webClientTest(@RequestParam String page) {
        Mono<String> mono = webClient
                .get()
                .uri("/" + page +"/json")
                .retrieve()
                .bodyToMono(String.class);
        String result = mono.block();
        mono.subscribe(System.out::println);
        return "结果: " + result;

    }
}
