package org.coursera.duke.java.week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

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

    public static String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestRecord = null;
        String fileName = null;
        for(File f : dr.selectedFiles()) {
            CSVParser parser = fileToParser(f);

            if(coldestRecord == null) {
                coldestRecord = coldestHourInFile(parser);
                fileName = f.getName();
            }
            else {
                CSVRecord currentFileColdestRecord = coldestHourInFile(parser);
                if(Double.parseDouble(currentFileColdestRecord.get("TemperatureF")) < Double.parseDouble(coldestRecord.get("TemperatureF"))) {
                    coldestRecord = currentFileColdestRecord;
                    fileName = f.getName();
                }
            }
        }
        printColdestFileInfo(fileName, coldestRecord);
        return fileName;
    }

    private static void printColdestFileInfo(String fileName, CSVRecord coldestRecord) {
        System.out.println("Coldest day was in file " + fileName);
        System.out.println("Coldest temperature on that day was " + coldestRecord.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        printAllFileTemperatures(fileName);
    }

    private static void printAllFileTemperatures(String fileName) {
        String year = fileName.substring(8, 12);
        FileResource fr = new FileResource("resources/week3/nc_weather/" + year + "/" + fileName);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord line : parser) {
            System.out.println(line.get("DateUTC") + ": " + line.get("TemperatureF"));
        }
    }

    public static CSVParser fileToParser(File f) {
        FileResource fr = new FileResource(f);
        return fr.getCSVParser();
    }
    public static void main(String[] args) {
        //testColdestHourInFile();
        fileWithColdestTemperature();
    }
}
