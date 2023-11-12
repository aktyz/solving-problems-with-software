package org.coursera.duke.java.week4;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FileData {
    public static final String TEST_DATA_LOCALISATION = "resources/week4/us_babynames_test/";
    public CSVParser readOneFile(int year) {
        String fileName = "data/yob" + year + ".txt";
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord line : parser) { // is this naming stored in parser?
            String name = line.get(0).toLowerCase();
            String gender = line.get(1).toLowerCase();
            int occurrences = Integer.parseInt(line.get(2));
        }
        return parser;
    }

    public static void printNames() {
        FileResource fr = new FileResource(TEST_DATA_LOCALISATION + "example-small.csv");
        for(CSVRecord line : fr.getCSVParser(false)) {
            System.out.println("Name: " + line.get(0) +
                    ", Gender: " + line.get(1) +
                    ", occurring: " + line.get(2)
            );
        }
    }

    public static void printRareNames(int rareValue) {
        FileResource fr = new FileResource(TEST_DATA_LOCALISATION + "example-small.csv");
        System.out.println();
        System.out.println("Printing names occurring les or equal to: " + rareValue + " times");
        for(CSVRecord line : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(line.get(2));
            if(numBorn <= 100) {
                System.out.println("Name: " + line.get(0) +
                        ", Gender: " + line.get(1) +
                        ", occurring: " + line.get(2)
                );
            }
        }
    }

    public static void totalBirths(FileResource fr) {
        int total = 0;
        int fBorn = 0;
        int mBorn = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(line.get(2));
            total += numBorn;

            if(line.get(1).equals("F")) fBorn += numBorn;
            if(line.get(1).equals("M")) mBorn += numBorn;

        }
        System.out.println();
        System.out.println("Total number of kids born: " + total);
        System.out.println("Girls born: " + fBorn);
        System.out.println("Boys born: " + mBorn);
    }
}
