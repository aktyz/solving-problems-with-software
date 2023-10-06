package org.coursera.duke.java.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WhichCountriesExport {

    public static CSVParser tester(FileResource fr) {
        CSVParser parser = fr.getCSVParser();
        return parser;
    }
    public static void listExporters(CSVParser parser, String exportOfInterest) {
        // for each row in the CSV File
        for(CSVRecord line : parser) {
            // Look at the "Exports" column
            String exports = line.get("Exports");
            // Check if it contains exportOfInterest
            if(exports.contains(exportOfInterest)) {
                // If so, write down the "Country" from that row
                String country = line.get("Country");
                System.out.println(country);
            }
        }
        System.out.println();
    }

    public static void getExportersOf(String good, FileResource fr) {
        listExporters(tester(fr), good);
    }

    public static void countryInfo(CSVParser parser, String country) {
        for(CSVRecord line : parser) {
            String dataCountry = line.get("Country");
            if(dataCountry.equals(country)) {
                System.out.println(dataCountry + ": "
                + line.get("Exports") + ": "
                + line.get("Value (dollars)"));
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    public static void getCountryInfo(String country, FileResource fr) {
        countryInfo(tester(fr), country);
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource();
        getExportersOf("coffee", fr);
        getCountryInfo("Peru", fr);
        getCountryInfo("Poland", fr);
    }
}
