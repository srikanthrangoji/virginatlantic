package com.virginatlantic.model;

import lombok.Data;

@Data
public class FlightDetailsResponse {
    private String departureTime;
    private String destination;
    private String destinationAirport;
    private String flightNo;
}
