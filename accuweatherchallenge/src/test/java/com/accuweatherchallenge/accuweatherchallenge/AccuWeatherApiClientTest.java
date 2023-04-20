package com.accuweatherchallenge.accuweatherchallenge;

import com.accuweatherchallenge.accuweatherchallenge.model.WeatherData;
import com.accuweatherchallenge.accuweatherchallenge.service.AccuWeatherApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccuWeatherApiClientTest {

    @Autowired
    private AccuWeatherApiClient accuWeatherApiClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetWeatherData() throws Exception {
        String locationKey = "12345";
        String apiKey = "BK8u5HTkyA1L7wleokpXtdsg6i3SW1NG";
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + locationKey + "?apikey=" + apiKey;

        String jsonResponse = "{\"Headline\":{\"Text\":\"Expect showers this morning\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseBody = objectMapper.readTree(jsonResponse);

        MockRestServiceServer mockServer = MockRestServiceServer.bindTo(restTemplate).build();
        mockServer.expect(requestTo(url))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody.toString(), MediaType.APPLICATION_JSON));

        WeatherData result = accuWeatherApiClient.getWeatherData(locationKey);

        assertEquals("\"Expect showers this morning\"", result.getWeatherText());
        mockServer.verify();
    }
}