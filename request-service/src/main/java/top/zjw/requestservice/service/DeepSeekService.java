package top.zjw.requestservice.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.alibaba.dashscope.utils.JsonUtils.gson;

@Service
@Configuration
public class DeepSeekService {

    @Resource
    private RestTemplate restTemplate;

    @Value("${apiKey}")
    private String apiKey;

    @Value("${model}")
    private String model;

    @Value("${url}")
    private String url;



    public String callDeepSeekAPI(String question) throws UnirestException, IOException {
        Unirest.setTimeouts(0, 0);


        List<DeepSeekRequest.Message> messages = new ArrayList<>();
        messages.add(DeepSeekRequest.Message.builder().role("system").content("你是一个语言学家").build());
        messages.add(DeepSeekRequest.Message.builder().role("user").content(question).build());

        // 构建请求体
        DeepSeekRequest requestBody = DeepSeekRequest.builder()
                .model(model)
                .messages(messages)
                .build();

        // 发送请求
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .body(gson.toJson(requestBody))
                .asString();

        // 解析响应并提取回答内容
        return extractResponseContent(response.getBody());
    }

    /**
     * 从响应体中提取回答内容
     *
     * @param responseBody DeepSeek API 的响应体
     * @return 回答内容
     */
    private String extractResponseContent(String responseBody) {
        // 使用 Gson 解析响应体
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

        // 提取 choices 数组中的第一个 message 的 content
        String content = jsonResponse.getAsJsonArray("choices")
                .get(0) // 获取第一个 choice
                .getAsJsonObject()
                .getAsJsonObject("message")
                .get("content")
                .getAsString();

        return content;
    }

    // DeepSeek 请求体的内部类
    public static class DeepSeekRequest {
        private String model;
        private List<Message> messages;

        public static DeepSeekRequestBuilder builder() {
            return new DeepSeekRequestBuilder();
        }

        public static class DeepSeekRequestBuilder {
            private String model;
            private List<Message> messages;

            public DeepSeekRequestBuilder model(String model) {
                this.model = model;
                return this;
            }

            public DeepSeekRequestBuilder messages(List<Message> messages) {
                this.messages = messages;
                return this;
            }

            public DeepSeekRequest build() {
                DeepSeekRequest request = new DeepSeekRequest();
                request.model = this.model;
                request.messages = this.messages;
                return request;
            }
        }

        public static class Message {
            private String role;
            private String content;

            public static MessageBuilder builder() {
                return new MessageBuilder();
            }

            public static class MessageBuilder {
                private String role;
                private String content;

                public MessageBuilder role(String role) {
                    this.role = role;
                    return this;
                }

                public MessageBuilder content(String content) {
                    this.content = content;
                    return this;
                }

                public Message build() {
                    Message message = new Message();
                    message.role = this.role;
                    message.content = this.content;
                    return message;
                }
            }
        }
    }
}
