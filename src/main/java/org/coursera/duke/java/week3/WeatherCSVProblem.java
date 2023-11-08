package org.coursera.duke.java.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WeatherCSVProblem {

    public static CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldest = null;
        for(CSVRecord currentLine : parser) {
            if(coldest == null) {
                coldest = currentLine;
            }
            else {
                if(Double.parseDouble(currentLine.get("TemperatureF")) < Double.parseDouble(coldest.get("TemperatureF"))) {
                    coldest = currentLine;
                }
            }
        }
        return coldest;
    }

    public static void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("TimeEST"));
    }
    public static void main(String[] args) {
        testColdestHourInFile();
    }
}
