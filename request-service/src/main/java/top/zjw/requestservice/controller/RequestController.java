package top.zjw.requestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zjw.requestservice.entity.User;
import top.zjw.requestservice.openfeign.NodeService;
import top.zjw.requestservice.service.UserService;

@RestController
public class RequestController {

    @Autowired
    private NodeService nodeService;
    @Autowired
    private UserService userService;


    @GetMapping("/request-user/{id}")
    public User requestUser(@PathVariable("id") Long id) {
        User user = nodeService.getUserById(id);
        System.out.println("从 node-service 获取的用户数据：" + user);
        return user;
    }
    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "用户信息已存储到 Redis: " + user;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}