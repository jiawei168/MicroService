package top.zjw.contentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.zjw.contentservice.config.RandomLoadBalancerConfig;
import top.zjw.contentservice.handler.SentinelConfig;

@Import({SentinelConfig.class})
@SpringBootApplication
@LoadBalancerClient(name="user-service",configuration= RandomLoadBalancerConfig.class)
@EnableFeignClients(basePackages = "top.zjw.contentservice.openfeign")
@MapperScan("top.zjw.contentservice.mapper")
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }

}
