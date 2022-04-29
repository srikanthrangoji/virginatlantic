package com.virginatlantic.transformer;

import com.virginatlantic.model.FlightDetailsMapper;
import com.virginatlantic.model.FlightDetailsResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ResponseMapperTest {

    @Mock
    ResponseMapper responseMapper;
    @Test
    void testMapResponse() throws FileNotFoundException {
        List<FlightDetailsMapper> details=getDetails();
        ReflectionTestUtils.setField(responseMapper,"mapper",details);
        List<FlightDetailsResponse> response=mockResponse();
        when(responseMapper.mapResponse("MONDAY")).thenReturn(response);
        List<FlightDetailsResponse> resp=responseMapper.mapResponse("MONDAY");
    }
    private List<FlightDetailsMapper> getDetails() {
        List<FlightDetailsMapper> mockDetails=new ArrayList<FlightDetailsMapper>();
        FlightDetailsMapper object= new FlightDetailsMapper();
        object.setDepartureTime("22:10:10");
        object.setFlightNo("C123");
        object.setDestination("USA");
        object.setDestinationAirport("NewYork");
        object.setMonday("x");
        mockDetails.add(object);
        return mockDetails;
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
