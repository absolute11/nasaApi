package nasa.nasaapi.controller;

import nasa.nasaapi.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NasaController {

    @Autowired
    private NasaService nasaService;

    @GetMapping("/picture")
    public String getAstronomyPictureOfTheDay() {
        return nasaService.getAstronomyPictureOfTheDay();
    }
}