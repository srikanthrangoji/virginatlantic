package com.virginatlantic.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class FlightDetailsMapper {


        @CsvBindByName(column = "Departure Time")
        private String departureTime;

        @CsvBindByName(column = "Destination")
        private String destination;

        @CsvBindByName(column = "Destination Airport IATA")
        private String destinationAirport;

        @CsvBindByName(column = "Flight No")
        private String FlightNo;

        @CsvBindByName(column = "Sunday")
        private String sunday;
        @CsvBindByName(column = "Monday")
        private String monday;
        @CsvBindByName(column = "Tuesday")
        private String tuesday;
        @CsvBindByName(column = "Wednesday")
        private String wednesday;
        @CsvBindByName(column = "Thursday")
        private String thursday;
        @CsvBindByName(column = "Friday")
        private String friday;
        @CsvBindByName(column = "Saturday")
        private String saturday;


}
