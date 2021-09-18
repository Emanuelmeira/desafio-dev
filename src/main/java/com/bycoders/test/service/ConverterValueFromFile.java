package com.bycoders.test.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ConverterValueFromFile {

    public LocalDate converterStringToDate(String dateString){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        var date = LocalDate.parse(dateString, formatter);

        return date;
    }

    public LocalTime converterStringToTime(String timeString){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");

        LocalTime localTimeObj = LocalTime.parse(timeString, formatter);
        return localTimeObj;
    }

}
