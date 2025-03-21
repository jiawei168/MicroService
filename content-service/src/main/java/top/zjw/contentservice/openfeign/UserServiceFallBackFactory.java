package top.zjw.contentservice.openfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.zjw.contentservice.model.dto.UserDTO;
import top.zjw.contentservice.model.entity.Result;
import top.zjw.contentservice.model.entity.User;

@Component
@Slf4j
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        log.error("用户服务调用异常",cause);
        return new UserService() {
            @Override
            public Result<UserDTO> getUserById(Integer id) {
                UserDTO user = new UserDTO();
                user.setUserId(-1);
                user.setUserName("异常用户名");
                user.setAvatarUrl("https://");
                return Result.success(user);
            }

        };
    }
}
