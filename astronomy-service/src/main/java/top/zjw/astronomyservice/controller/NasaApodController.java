package top.zjw.astronomyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zjw.astronomyservice.service.NasaApodService;

@RestController
@RequestMapping("/api/nasa")
public class NasaApodController {

    @Autowired
    private NasaApodService nasaApodService;

    @GetMapping("/apod")
    public String getAstronomyPictureOfTheDay() {
        return nasaApodService.getAstronomyPictureOfTheDay();
    }
}