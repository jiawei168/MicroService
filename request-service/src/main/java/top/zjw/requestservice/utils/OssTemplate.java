package top.zjw.requestservice.utils;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.zjw.requestservice.config.OssConfig;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author 86139
 */
@Component
public class OssTemplate {
    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    public String uploadFile(MultipartFile file) {
        try {
            //获取文件的原始名称
            String originalFilename = file.getOriginalFilename();
            if(originalFilename == null) {
                throw new IllegalArgumentException("文件名称不能为空");
            }
            //生成唯一文件名，防止覆盖
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            //获取文件输入流
            InputStream inputStream = file.getInputStream();
            //上传文件到OSS
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            //构建文件的URL路径
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint().replace("https://","") + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败",e);
        }
    }
}
