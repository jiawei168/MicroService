package top.zjw.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zjw.userservice.entity.User;
;

public interface UserService extends IService<User> {
    User getUserById(Integer id);
}