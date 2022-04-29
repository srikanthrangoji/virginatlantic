package com.virginatlantic.service;

import com.virginatlantic.model.FlightDetailsResponse;
import com.virginatlantic.transformer.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class VirginAtlanticService {

    @Autowired
    ResponseMapper responseMapper;

    /*
     * This will accept the day of the week as input and returns the flights available for that day.
     *@param String day
     * @return List<FlightDetailsResponse>
     */
    public List<FlightDetailsResponse> getFlightsForTheDay(String day) throws FileNotFoundException {
        return responseMapper.mapResponse(day);
    }

}
