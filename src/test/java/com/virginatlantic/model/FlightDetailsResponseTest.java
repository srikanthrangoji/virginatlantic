package com.virginatlantic.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class FlightDetailsResponseTest {

    public FlightDetailsResponse getObject(){
        return  new FlightDetailsResponse();
    }
    @Test
    void testGetSetMethods(){
        FlightDetailsResponse object=getObject();
        object.setDepartureTime("22:10:10");
        object.setFlightNo("C123");
        object.setDestination("USA");
        object.setDestinationAirport("NewYork");
        assertEquals("22:10:10",object.getDepartureTime());
        assertEquals("C123",object.getFlightNo());
        assertEquals("USA",object.getDestination());
        assertEquals("NewYork",object.getDestinationAirport());
    }
}
