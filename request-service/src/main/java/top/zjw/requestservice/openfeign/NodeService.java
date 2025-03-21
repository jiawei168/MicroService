package top.zjw.requestservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zjw.requestservice.entity.User;

@FeignClient(name = "node-service")
public interface NodeService {
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable("id") Long id);
}