package top.zjw.requestservice.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.zjw.requestservice.utils.OssTemplate;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 86139
 */
@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileUploadController {

    @Resource
    private OssTemplate ossTemplate;


     @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.uploadFile(file);
    }
}