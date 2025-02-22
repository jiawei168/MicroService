package top.zjw.aiservice.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zjw.aiservice.service.AiService;

@RestController
@RequestMapping()
public class AiController {
    @Resource
    private AiService aiService;

    @PostMapping("/query")
    public String query(@RequestBody String question) {
        return aiService.queryAiModel(question);
    }
}