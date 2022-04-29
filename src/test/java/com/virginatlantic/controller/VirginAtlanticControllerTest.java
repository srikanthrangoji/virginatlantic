package com.virginatlantic.controller;

import com.virginatlantic.model.FlightDetailsResponse;
import com.virginatlantic.service.VirginAtlanticService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class VirginAtlanticControllerTest {

    @InjectMocks
    VirginAtlanticController virginAtlanticController;

    @Mock
    VirginAtlanticService virginAtlanticService;

    @Test
    void testGetFlightDetails() throws Exception {
        List<FlightDetailsResponse> response=mockResponse();
        when(virginAtlanticService.getFlightsForTheDay(Mockito.anyString())).thenReturn(response);
        ResponseEntity<List<FlightDetailsResponse>> getFlightDetails=virginAtlanticController.getFlightDetails("2022-12-12");
        assertNotNull(getFlightDetails);
    }

    @Test
    void testInvalidDate() throws Exception {
        List<FlightDetailsResponse> response=mockResponse();
        when(virginAtlanticService.getFlightsForTheDay(Mockito.anyString())).thenReturn(response);
        try {
            ResponseEntity<List<FlightDetailsResponse>> getFlightDetails = virginAtlanticController.getFlightDetails("2022-23-12");
        }catch(Exception ex) {
            assertNotNull(ex);
        }
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
