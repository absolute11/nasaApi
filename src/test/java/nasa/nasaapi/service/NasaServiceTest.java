package nasa.nasaapi.service;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import nasa.nasaapi.feign.NasaClient;
import nasa.nasaapi.feign.NasaResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NasaServiceTest {

    @Autowired
    private NasaService nasaService;

    @MockBean
    private NasaClient nasaClient;

    @RegisterExtension
    static WireMockExtension wireMockRule = WireMockExtension.newInstance()
            .options(WireMockConfiguration.wireMockConfig().dynamicPort())
            .build();

    @BeforeEach
    void setup() {
        wireMockRule.stubFor(get(urlPathEqualTo("/planetary/apod"))
                .withQueryParam("api_key", equalTo("B9UvJvWusDxhvR8BnEgDEKLy9T6iS3NShnQSYkds"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"url\": \"http://example.com/image.jpg\", \"media_type\": \"image\"}")));
    }

    @Test
    public void testGetAstronomyPictureOfTheDay() {
        NasaResponse nasaResponse = new NasaResponse();
        nasaResponse.setUrl("http://example.com/image.jpg");
        nasaResponse.setMedia_type("image");

        given(nasaClient.getAstronomyPictureOfTheDay("B9UvJvWusDxhvR8BnEgDEKLy9T6iS3NShnQSYkds"))
                .willReturn(new ResponseEntity<>(nasaResponse, HttpStatus.OK));

        String result = nasaService.getAstronomyPictureOfTheDay();
        assertEquals("http://example.com/image.jpg", result);
    }
}