package com.virginatlantic.transformer;

import com.virginatlantic.model.FlightDetailsMapper;
import com.virginatlantic.model.FlightDetailsResponse;
import com.virginatlantic.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseMapper {
    @Autowired
    @Qualifier("csvData")
    List<FlightDetailsMapper> mapper;
/*
* This will return the flight details of a particular day of the week
* @param day .The day in the week for which we need to fetch the flight details
* @returns List<FlightDetailsResponse>. List of flight details for the particular day in the week
*/
    public List<FlightDetailsResponse> mapResponse(String day) throws FileNotFoundException {
        List<FlightDetailsResponse> response=new ArrayList<FlightDetailsResponse>();
        for(FlightDetailsMapper row:mapper){
            if(getDay(row,day)){
                FlightDetailsResponse res= new FlightDetailsResponse();
                res.setDepartureTime(row.getDepartureTime());
                res.setDestinationAirport(row.getDestinationAirport());
                res.setDestination(row.getDestination());
                res.setFlightNo(row.getFlightNo());
                response.add(res);
            }
        }
        return response;
    }
    /*
     * This will return boolean if the data is present for the passed day
     *@param FlightDetailsMapper and Date
     * @return boolaen
     */
    private boolean getDay(FlightDetailsMapper row, String day) {
        boolean result=false;
        if(Constants.MONDAY.equalsIgnoreCase(day) && row.getMonday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.TUESDAY.equalsIgnoreCase(day) && row.getTuesday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.WEDNESDAY.equalsIgnoreCase(day) && row.getWednesday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.THURSDAY.equalsIgnoreCase(day) && row.getThursday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.FRIDAY.equalsIgnoreCase(day) && row.getFriday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.SATURDAY.equalsIgnoreCase(day) && row.getSaturday().equalsIgnoreCase("x")){
            result=true;
        }else if(Constants.SUNDAY.equalsIgnoreCase(day) && row.getSunday().equalsIgnoreCase("x")){
            result=true;
        }
        return result;
    }
}
