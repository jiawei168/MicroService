package top.zjw.astronomyservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.zjw.astronomyservice.entity.ApodResponse;

@Service
public class NasaApodService {

    private static final String NASA_APOD_URL = "https://api.nasa.gov/planetary/apod?api_key=9DCQWXu6timt7VBBB0jMIbsyvmFoeQrFy996ZEwp";

    public String getAstronomyPictureOfTheDay() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ApodResponse apodResponse = restTemplate.getForObject(NASA_APOD_URL, ApodResponse.class);
            return apodResponse != null ? apodResponse.toString() : "Failed to fetch astronomy picture of the day.";
        } catch (Exception e) {
            return "Error fetching astronomy picture: " + e.getMessage();
        }
    }
}