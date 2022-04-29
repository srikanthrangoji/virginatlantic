package com.virginatlantic.config;

import com.opencsv.bean.CsvToBeanBuilder;
import com.virginatlantic.model.FlightDetailsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Configuration
public class LoadCsvFile {

    @Bean(name = "csvData")
    public List<FlightDetailsMapper> mapResponse() throws FileNotFoundException {
        File file = new File("./src/main/resources/files/flights.csv");
        List<FlightDetailsMapper> mapper = new CsvToBeanBuilder(new FileReader(file))
                .withType(FlightDetailsMapper.class)
                .build()
                .parse();
        return mapper;
    }
}
