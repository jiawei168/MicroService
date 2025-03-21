package top.zjw.contentservice.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentinelConfig {

    @Bean
    public BlockExceptionHandler SentinelExceptionHandler(){
        return new SentinelExceptionHandler();
    }

    @Bean
    public RequestOriginParser SentinelRequestOriginParser(){
        return new SentinelRequestOriginParser();
    }

}
