package top.zjw.aiservice.service;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20210707.RecognizeGeneralRequest;
import com.aliyuncs.ocr.model.v20210707.RecognizeGeneralResponse;
import com.aliyuncs.profile.DefaultProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.zjw.aiservice.config.AliyunOcrConfig;

import java.util.Base64;

@Service
public class OcrService {

    @Autowired
    private AliyunOcrConfig aliyunOcrConfig;

    public String recognize(MultipartFile file) throws Exception {
        // 初始化阿里云客户端
        DefaultProfile profile = DefaultProfile.getProfile(
                aliyunOcrConfig.getRegionId(),
                aliyunOcrConfig.getAppKey(),
                aliyunOcrConfig.getAppSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        // 构建请求
        RecognizeGeneralRequest request = new RecognizeGeneralRequest();
        request.setMethod(com.aliyuncs.http.MethodType.POST);
        request.setProtocol(com.aliyuncs.http.ProtocolType.HTTPS);
        request.setAcceptFormat(com.aliyuncs.http.FormatType.JSON);

        // 将图片文件转换为 Base64 编码
        byte[] fileBytes = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(fileBytes);
        request.setImage(base64Image);

        // 发起请求并获取响应
        try {
            RecognizeGeneralResponse response = client.getAcsResponse(request);
            return response.getData();
        } catch (ServerException e) {
            throw new RuntimeException("Server Exception: " + e.getMessage(), e);
        } catch (ClientException e) {
            throw new RuntimeException("Client Exception: " + e.getMessage(), e);
        }
    }
}