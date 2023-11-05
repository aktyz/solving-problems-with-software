package org.coursera.duke.java.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

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
                System.out.println();
                return;
            }
        }
        System.out.println("NOT FOUND");
        System.out.println();
    }

    public static void getCountryInfo(String country, FileResource fr) {
        countryInfo(tester(fr), country);
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord line : parser) {
            String dataCountry = line.get("Country");
            String countryExportsLine = line.get("Exports");
            if(countryExportsLine.contains(exportItem1) && countryExportsLine.contains(exportItem2))
                System.out.println(dataCountry);

        }
        System.out.println();
    }

    public static void getListExportersTwoProducts(String exportItem1, String exportItem2, FileResource fr) {
        listExportersTwoProducts(tester(fr), exportItem1, exportItem2);
    }

    public static void numberOfExporters(CSVParser parser, String exportItem) {
        int numberOfExporters = 0;
        for(CSVRecord line : parser) {
            String countryExportsLine = line.get("Exports");
            ArrayList<String> countryExportItems = new ArrayList<String>();
            int beginIndex = 0;
            int endIndex = countryExportsLine.indexOf(",");

            while(endIndex < countryExportsLine.length() && !(endIndex == -1)) {
                countryExportItems.add(countryExportsLine.substring(beginIndex, endIndex));
                beginIndex = endIndex + 2;
                endIndex = countryExportsLine.indexOf(",", endIndex + 1);
                if(endIndex == -1)
                {
                    endIndex = countryExportsLine.length();
                    countryExportItems.add(countryExportsLine.substring(beginIndex,endIndex));
                }
            }

            for(String good : countryExportItems) {
                if(good.contains(exportItem))
                    numberOfExporters ++;
            }
        }
        System.out.println(numberOfExporters);
        System.out.println();
    }

    public static void getNumberOfExporters(String exportItem, FileResource fr) {
        numberOfExporters(tester(fr), exportItem);
    }

    private static void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord line : parser) {
            String countryExportsValue = line.get("Value (dollars)");
            if(countryExportsValue.length() > amount.length())
                System.out.println(line.get("Country") + " " + countryExportsValue);
        }
        System.out.println();
    }

    public static void getBigExporters(String amount, FileResource fr) {
        bigExporters(tester(fr), amount);
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource("resources/week3/exportdata.csv");
        getExportersOf("coffee", fr);
        getCountryInfo("Nauru", fr);
        getCountryInfo("Poland", fr);
        getListExportersTwoProducts("gold", "diamonds", fr);
        getNumberOfExporters("sugar", fr);
        getBigExporters("$999,999,999,999", fr);
    }
}
