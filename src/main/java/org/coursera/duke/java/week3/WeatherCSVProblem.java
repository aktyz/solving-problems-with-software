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
            if(!(Double.parseDouble(currentLine.get("TemperatureF")) == -9999)) {
                if(coldest == null) {
                    coldest = currentLine;
                }
                else {
                    if(Double.parseDouble(currentLine.get("TemperatureF")) < Double.parseDouble(coldest.get("TemperatureF"))) {
                        coldest = currentLine;
                    }
                }
            }
        }
        return coldest;
    }

    public static void testColdestHourInFile() {
        FileResource fr = new FileResource("resources/week3/nc_weather/2014/weather-2014-05-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Question 3:");
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("TimeEDT"));
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
        System.out.println("Question 10 & 11:");
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

    public static CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidityRecord = null;
        for(CSVRecord currentLine : parser) {
            String humidity = currentLine.get("Humidity");
            if(!humidity.equals("N/A")) {
                int currentHumidityValue = Integer.parseInt(humidity);
                if(lowestHumidityRecord == null) lowestHumidityRecord = currentLine;
                else {
                    int lowestHumidityValue = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
                    if(currentHumidityValue < lowestHumidityValue) lowestHumidityRecord = currentLine;
                }
            }
        }
        return lowestHumidityRecord;
    }

    public static void testLowestHumidityInFile() {
        FileResource fr = new FileResource("resources/week3/nc_weather/2014/weather-2014-06-29.csv");
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Question 4:");
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
        FileResource fr2 = new FileResource("resources/week3/nc_weather/2014/weather-2014-07-22.csv");
        CSVParser parser2 = fr2.getCSVParser();
        CSVRecord csv2 = lowestHumidityInFile(parser2);
        System.out.println("Question 5:");
        System.out.println("Lowest Humidity was " + csv2.get("Humidity") + " at " + csv2.get("DateUTC"));

    }

    public static CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidityRecord = null;
        for(File f : dr.selectedFiles()) {
            CSVParser parser = fileToParser(f);
            if(lowestHumidityRecord == null) {
                lowestHumidityRecord = lowestHumidityInFile(parser);
            }
            else {
                CSVRecord currentParserLowestHumidity = lowestHumidityInFile(parser);
                int currentLowestHumidity = Integer.parseInt(currentParserLowestHumidity.get("Humidity"));
                int lowestHumidity = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
                if(currentLowestHumidity < lowestHumidity) {
                    lowestHumidityRecord = currentParserLowestHumidity;
                }
            }
        }
        return lowestHumidityRecord;
    }

    public static void testLowestHumidityInManyFiles() {
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        System.out.println("Question 6 & 7:");
        System.out.println("Lowest Humidity was " + lowestHumidity.get("Humidity") + " at " + lowestHumidity.get("DateUTC"));
    }

    public static CSVParser fileToParser(File f) {
        FileResource fr = new FileResource(f);
        return fr.getCSVParser();
    }

    public static double averageTemperatureInFile(CSVParser parser) {
        int index = 0;
        double sum = 0;
        for(CSVRecord line : parser) {
            double temperatureValue = Double.parseDouble(line.get("TemperatureF"));
            sum += temperatureValue;
            index++;
        }
        return index == 0 ? 0 : sum/index;
    }

    public static void testAverageTemperatureInFile() {
        FileResource fr = new FileResource("resources/week3/nc_weather/2013/weather-2013-08-10.csv");
        System.out.println("Question 8:");
        double averageTemperature = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperature);
    }

    /** This method returns a double
     * that represents the average temperature of
     * only those temperatures when the humidity was greater than or equal to value */
    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0;
        int index = 0;
        for(CSVRecord currentLine : parser) {
            double lineTemperature = Double.parseDouble(currentLine.get("TemperatureF"));
            int lineHumidity = Integer.parseInt(currentLine.get("Humidity"));
            if(lineHumidity >= value) {
                sum += lineTemperature;
                index++;
            }
        }
        return index == 0 ? 0 : sum/index;
    }

    public static void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource("resources/week3/nc_weather/2013/weather-2013-09-02.csv");
        double averageTemperature = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80);
        System.out.println("Question 9:");
        if(!(averageTemperature == 0)) System.out.println("Average Temp when high Humidity is " + averageTemperature);
        else System.out.println("No temperatures with that humidity");
    }

    public static void main(String[] args) {
        testLowestHumidityInFile();
        testLowestHumidityInManyFiles();
        testAverageTemperatureInFile();
        testAverageTemperatureWithHighHumidityInFile();
        fileWithColdestTemperature();

//        testColdestHourInFile();
//        fileWithColdestTemperature();
//        testLowestHumidityInFile();
//        testLowestHumidityInManyFiles();
//        testAverageTemperatureInFile();
//        testAverageTemperatureWithHighHumidityInFile();
    }
}
