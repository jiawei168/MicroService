package top.zjw.aiservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/recognize")
    public String recognize(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty!";
        }
        try {
            String result = ocrService.recognize(file);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during OCR recognition: " + e.getMessage();
        }
    }
}