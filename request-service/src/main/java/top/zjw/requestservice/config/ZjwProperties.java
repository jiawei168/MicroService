package top.zjw.requestservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(prefix="zjw")
public class ZjwProperties {
    private String username;
    private String job;
    private Boolean serviceFlag;
}
