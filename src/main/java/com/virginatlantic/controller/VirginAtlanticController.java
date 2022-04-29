package com.virginatlantic.controller;

import com.virginatlantic.model.FlightDetailsResponse;
import com.virginatlantic.service.VirginAtlanticService;
import com.virginatlantic.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VirginAtlanticController {

    @Autowired
    VirginAtlanticService virginAtlanticService;
    /*
    * This will accept the data yyyy-mm-dd as input and returns the flights available for that day from the provided csv file
    *@param date
    * @return List<FlightDetailsResponse>
    */
    @GetMapping(value ="/getFlights")
    public ResponseEntity<List<FlightDetailsResponse>> getFlightDetails(@RequestParam(required = true) String date) throws Exception{
        List<FlightDetailsResponse> response=null;
        try {
            CommonUtils.validateDate(date);
            String day = CommonUtils.getWeekDay(date);
            response = virginAtlanticService.getFlightsForTheDay(day);
        }catch(Exception ex){
            throw ex;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
