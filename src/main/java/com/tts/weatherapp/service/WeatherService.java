package com.tts.weatherapp.service;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCode;
import com.tts.weatherapp.repository.ZipCodeRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
  
    @Value("${api_key}")
    private String apiKey;

    @Autowired
	private ZipCodeRepository zipCodeRepository;

    //Make a call to Openweather api with dynamic zipcode and apikey
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + 
            zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        ZipCode zipCodeHistory = new ZipCode();
        zipCodeHistory.setZipCode(zipCode);
        zipCodeRepository.save(zipCodeHistory);

        try{
        return restTemplate.getForObject(url, Response.class);

        }
        catch(HttpClientErrorException exception){
            Response response = new Response();
            response.setName("ERROR");
            return response;
        }
    }
    public Iterable<ZipCode> findAllZipCode() {
		return zipCodeRepository.findAll();
	}

}

