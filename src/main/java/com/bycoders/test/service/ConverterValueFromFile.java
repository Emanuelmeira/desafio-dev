package com.bycoders.test.service;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ConverterValueFromFile {

    public LocalDate converterStringToDate(String dateString){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        var date = LocalDate.parse(dateString, formatter);

        return date;
    }

    public LocalTime converterStringToTime(String timeString){

        DateFormat formatter = new SimpleDateFormat("hhmmss");
        Date date = null;

        try {
            date = (Date) formatter.parse(timeString);
            System.out.println(date);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
