package nasa.nasaapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "nasaClient", url = "${nasa.api.url}")
public interface NasaClient {

    @GetMapping("/planetary/apod")
    ResponseEntity<NasaResponse> getAstronomyPictureOfTheDay(@RequestParam("api_key") String apiKey);
}