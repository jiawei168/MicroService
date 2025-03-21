package top.zjw.requestservice.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.zjw.requestservice.entity.User;

@Service
public class UserService {

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    /**
     * 将 User 对象存储到 Redis 中
     */
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
        System.out.println("用户信息已存储到 Redis: " + user);
    }

    /**
     * 从 Redis 中获取 User 对象
     */
    public User getUser(String id) {
        User user = redisTemplate.opsForValue().get(id);
        System.out.println("从 Redis 中获取用户信息: " + user);
        return user;
    }

    /**
     * 删除 Redis 中的 User 对象
     */
    public void deleteUser(String id) {
        redisTemplate.delete(id);
        System.out.println("从 Redis 中删除用户信息: " + id);
    }
}