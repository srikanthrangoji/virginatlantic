package com.virginatlantic.service;

import com.virginatlantic.model.FlightDetailsResponse;
import com.virginatlantic.transformer.ResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class VirginAtlanticServiceTest {
    @InjectMocks
    VirginAtlanticService virginAtlanticService;

    @Mock
    ResponseMapper responseMapper;

    @Test
    void testGetFlightsForTheDay() throws FileNotFoundException {
        List<FlightDetailsResponse> response=mockResponse();
        when(responseMapper.mapResponse(Mockito.anyString())).thenReturn(response);
        List<FlightDetailsResponse> getFlightsForTheDay=virginAtlanticService.getFlightsForTheDay(Mockito.anyString());
        assertNotNull(getFlightsForTheDay);
        assertEquals(getFlightsForTheDay.get(0).getFlightNo(),response.get(0).getFlightNo());
        assertEquals(getFlightsForTheDay.get(0).getDepartureTime(),response.get(0).getDepartureTime());
        assertEquals(getFlightsForTheDay.get(0).getDestination(),response.get(0).getDestination());
        assertEquals(getFlightsForTheDay.get(0).getDestinationAirport(),response.get(0).getDestinationAirport());
    }
    public List<FlightDetailsResponse> mockResponse(){
        List<FlightDetailsResponse> mockResponse= new ArrayList<FlightDetailsResponse>();
        FlightDetailsResponse flightDetailsResponse=new FlightDetailsResponse();
        flightDetailsResponse.setFlightNo("C123");
        flightDetailsResponse.setDestination("USA");
        flightDetailsResponse.setDepartureTime("22:15:15");
        flightDetailsResponse.setDestinationAirport("NewYork");
        mockResponse.add(flightDetailsResponse);
        return mockResponse;
    }
}
