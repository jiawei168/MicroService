package top.zjw.requestservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String host;
    private int port;
    private String password;
    private int database;
    private int timeout;
    private Pool pool;

    // Getters and Setters

    public static class Pool {
        private int maxActive;
        private int maxIdle;
        private int minIdle;
        private long maxWait;

        // Getters and Setters
    }
}