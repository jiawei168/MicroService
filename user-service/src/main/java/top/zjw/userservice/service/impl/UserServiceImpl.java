package top.zjw.userservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import top.zjw.userservice.entity.User;
import top.zjw.userservice.mapper.UserMapper;
import top.zjw.userservice.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUserById(Integer id) {
        return this.getById(id);
    }
}