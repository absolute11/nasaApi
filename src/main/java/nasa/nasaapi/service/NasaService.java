package nasa.nasaapi.service;

import nasa.nasaapi.feign.NasaClient;
import nasa.nasaapi.feign.NasaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class NasaService {

    @Autowired
    private NasaClient nasaClient;

    @Value("${nasa.api.key}")
    private String apiKey;

    public String getAstronomyPictureOfTheDay() {
        ResponseEntity<NasaResponse> response = nasaClient.getAstronomyPictureOfTheDay(apiKey);
        if (response.getBody().getMedia_type().equals("image")) {
            return response.getBody().getUrl();
        } else {
            return "https://img.youtube.com/vi/" + response.getBody().getUrl() + "/0.jpg";
        }
    }
}