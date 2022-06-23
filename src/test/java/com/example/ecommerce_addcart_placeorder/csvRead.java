package com.example.ecommerce_addcart_placeorder;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class csvRead {

    CSVReader signup_data_read;

    {
        try {
            signup_data_read = new CSVReader (new FileReader("/home/shahriar/CrowdTank/crowdTankTest/signUpData.csv"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    String[] csvCell;
}
