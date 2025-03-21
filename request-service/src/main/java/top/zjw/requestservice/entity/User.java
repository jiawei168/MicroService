package top.zjw.requestservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String mobile;
    private String password;
    private String userName;

//    @JsonProperty("avatar_url")
//    private String avatarUrl;
//
//    @JsonProperty("create_time")
//    private Date createTime;
//
//    @JsonProperty("update_time")
//    private Date updateTime;
//    // Getters and Setters

}