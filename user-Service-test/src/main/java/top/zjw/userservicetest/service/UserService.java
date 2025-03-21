package top.zjw.userservicetest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zjw.userservicetest.entity.User;


public interface UserService extends IService<User> {
    User getUserById(Integer id);
}