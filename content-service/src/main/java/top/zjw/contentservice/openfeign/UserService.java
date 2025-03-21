package top.zjw.contentservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.zjw.contentservice.model.dto.UserDTO;
import top.zjw.contentservice.model.entity.Result;
import top.zjw.contentservice.model.entity.User;

@FeignClient(value = "user-service",fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {
    @GetMapping(value = "/info/{id}")
    Result<UserDTO> getUserById(@PathVariable Integer id);

}
