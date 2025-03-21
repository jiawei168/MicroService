package top.zjw.voiceservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zjw.voiceservice.service.JokeService;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/random")
    public String getRandomJoke() {
        return jokeService.getRandomJoke();
    }
}