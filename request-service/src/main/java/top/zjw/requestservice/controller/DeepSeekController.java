package top.zjw.requestservice.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.zjw.requestservice.service.DeepSeekService;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class DeepSeekController {

    @Resource
    private DeepSeekService deepSeekService;

    @PostMapping("/DeepSeek")
    public String DeepSeek(@RequestBody String question) throws UnirestException, IOException {
        return deepSeekService.callDeepSeekAPI(question);
    }

}