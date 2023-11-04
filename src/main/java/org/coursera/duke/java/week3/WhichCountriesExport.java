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
                return;
            }
        }
        System.out.println("NOT FOUND");
    }

    public static void getCountryInfo(String country, FileResource fr) {
        countryInfo(tester(fr), country);
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        ArrayList<String> exportingCountries = new ArrayList<>();
        for(CSVRecord line : parser) {
            String dataCountry = line.get("Country");
            String countryExportsLine = line.get("Exports");
            int index = 0;
            while(index < countryExportsLine.length()) {
                String exportGood;
                int commaIndex = countryExportsLine.indexOf(",", index);
                if (commaIndex == -1) {
                    exportGood = countryExportsLine.substring(index, countryExportsLine.length());
                    index = countryExportsLine.length();
                } else {
                    exportGood = countryExportsLine.substring(index, commaIndex);
                    index = countryExportsLine.indexOf(",", commaIndex) + 1;
                }
                if(exportGood.equals(exportItem1) || exportGood.equals(exportItem2)) {
                    exportingCountries.add(dataCountry);
                }
            }
        }
        for(String country : exportingCountries) {
            System.out.println(country);
        }
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

            while(endIndex < countryExportsLine.length()) {
                countryExportItems.add(countryExportsLine.substring(beginIndex, endIndex));
                beginIndex = endIndex + 1;
                endIndex = countryExportsLine.indexOf(",", endIndex + 1);
                if(endIndex == -1) endIndex = countryExportsLine.length();
            }

            for(String good : countryExportItems) {
                if(good.equals(exportItem)) numberOfExporters ++;
            }
        }
        System.out.println(numberOfExporters);
    }

    public static void getNumberOfExporters(String exportItem, FileResource fr) {
        numberOfExporters(tester(fr), exportItem);
    }
    public static void main(String[] args) {
        FileResource fr = new FileResource();
        getExportersOf("coffee", fr);
        getCountryInfo("Peru", fr);
        getCountryInfo("Poland", fr);
        getListExportersTwoProducts("gold", "diamonds", fr);
        getNumberOfExporters("gold", fr);
    }
}
