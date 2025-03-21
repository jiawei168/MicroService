//package top.zjw.userservice.controller;
//
//import jakarta.annotation.Resource;
//
//import org.springframework.web.bind.annotation.*;
//import top.zjw.userservice.service.UserService1;
//
//
//@RestController
//public class UserController1 {
//    @GetMapping("/user")
//    public String getUser(@RequestParam String username){
//        return "User: " + username;
//    }
//    @Resource
//    private UserService1 userService;
//
//    @PostMapping("/ask")
//    public String ask(@RequestBody String question) {
//        return userService.queryAiModel(question);
//    }
//
//    @PostMapping("/add-to-cart")
//    public String addToCart(@RequestParam String productId, @RequestParam int quantity) {
//        return userService.addToCart(productId, quantity);
//    }
//    @GetMapping("/cart")
//    public String getCart() {
//        return userService.getCart();
//    }
//}
