package org.coursera.duke.java.week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMax {
    public static CSVRecord hottestHourInFile(CSVParser parser) {
        // start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
            if(largestSoFar == null) {
                largestSoFar = currentRow;
            }
            //Ohterwise
            else {
                //Check if currentRow's temperature > lartestSoFar
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //If so update largestSoFar to currentRow
                if(currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }

    public static void testHottestInDay () {
        FileResource fr = new FileResource("resources/week3/nc_weather/2015/weather-2015-01-02.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));;
    }

    public static CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if(largestSoFar == null) largestSoFar = currentRow;
            else {
                //Check if currentRow's temperature > lartestSoFar
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //If so update largestSoFar to currentRow
                if(currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        return  largestSoFar;
    }

    public static void testHottestInManyDays () {
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
    }
    public static void main (String[] args) {
        testHottestInManyDays();
    }
}
