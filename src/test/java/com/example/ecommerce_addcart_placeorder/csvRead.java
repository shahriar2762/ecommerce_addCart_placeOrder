package com.example.ecommerce_addcart_placeorder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class csvRead {

    CSVReader address_data;

    {
        try {
            address_data = new CSVReaderBuilder(new FileReader("/home/shahriar/ecommerce_addCart_placeOrder/ecommerce_addCart_placeOrder/dataFile/ecom_Data_file.csv")).withSkipLines(1).build();
//            address_data.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    String[] csvCell;
}
