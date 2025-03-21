package top.zjw.userservicetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.zjw.userservicetest.mapper")
public class UserServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceTestApplication.class, args);
    }

}
