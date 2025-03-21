package top.zjw.voiceservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.zjw.voiceservice.entity.Joke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;

@Service
public class JokeService {

    private static final Logger logger = LoggerFactory.getLogger(JokeService.class);
    private static final String JOKE_API_URL = "https://v2.jokeapi.dev/joke/Any";

    public String getRandomJoke() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            logger.info("Fetching joke from API: {}", JOKE_API_URL);
            ResponseEntity<String> response = restTemplate.getForEntity(JOKE_API_URL, String.class);
            logger.info("API Response: {}", response.getBody()); // 打印原始响应
            Joke joke = restTemplate.getForObject(JOKE_API_URL, Joke.class);
            return joke != null ? joke.toString() : "Failed to fetch a joke.";
        } catch (Exception e) {
            logger.error("Error fetching joke: {}", e.getMessage());
            return "Error fetching joke: " + e.getMessage();
        }
    }
}