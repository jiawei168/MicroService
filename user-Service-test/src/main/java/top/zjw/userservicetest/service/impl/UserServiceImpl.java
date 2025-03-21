package top.zjw.userservicetest.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zjw.userservicetest.entity.User;
import top.zjw.userservicetest.mapper.UserMapper;
import top.zjw.userservicetest.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUserById(Integer id) {
        return this.getById(id);
    }
}