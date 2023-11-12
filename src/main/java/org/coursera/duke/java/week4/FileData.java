package org.coursera.duke.java.week4;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class FileData {

    public static final String FEMALE = "f";
    public static final String MALE = "m";
    public static final String TEST_DATA_LOCALISATION = "resources/week4/us_babynames_test/";
    public CSVParser readOneFile(int year) {
        String fileName = "yob" + year + "short.txt";
        FileResource fr = new FileResource(TEST_DATA_LOCALISATION + fileName);
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
        System.out.println("Printing names occurring less or equal to: " + rareValue + " times");
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

    public static int totalBirths(FileResource fr) {
        int total = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(line.get(2));
            total += numBorn;
        }
        System.out.println("Total number of kids born: " + total);
        return total;
    }

    public static int getNumberOfFemaleNames(FileResource fr) {
        int fNames = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            String lineGender = line.get(1).toLowerCase();
            if(lineGender.equals(FEMALE))
                fNames ++;
        }
        System.out.println("Total number of female names in the file: " + fNames);
        return fNames;
    }

    public static int getNumberOfMaleNames(FileResource fr) {
        int mNames = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            String lineGender = line.get(1).toLowerCase();
            if(lineGender.equals(MALE))
                mNames ++;
        }
        System.out.println("Total number of male names in the file: " + mNames);
        return mNames;
    }

    public static int totalGirlsBorn(FileResource fr) {
        int total = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(line.get(2));
            String gender = line.get(1).toLowerCase();
            if(gender.equals(FEMALE)) total += numBorn;
        }
        System.out.println("Total number of girls born: " + total);
        return total;
    }

    public static int totalBoysBorn(FileResource fr) {
        int total = 0;
        for(CSVRecord line : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(line.get(2));
            String gender = line.get(1).toLowerCase();
            if(gender.equals(MALE)) total += numBorn;
        }
        System.out.println("Total number of boys born: " + total);
        return total;
    }

    public static int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource(TEST_DATA_LOCALISATION + "yob" + year + "short.csv");
        String workingName = name.toLowerCase();
        String workingGender = gender.toLowerCase();
        int numberOfNames = 0;
        switch (workingGender) {
            case FEMALE:
                numberOfNames = getNumberOfFemaleNames(fr);
                break;
            case MALE:
                numberOfNames = getNumberOfMaleNames(fr);
                break;
            default:
                return -1;
        }
        int rank = 0;
        for (CSVRecord line : fr.getCSVParser(false)) {
            String recordName = line.get(0).toLowerCase();
            String recordGender = line.get(1).toLowerCase();
            if (recordGender.equals(workingGender) && rank < numberOfNames) rank++;
            if(recordName.equals(workingName)) break;
        }
        if(rank == numberOfNames) return -1;
        return rank == 0 ? -1 : rank;
    }

    public static String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource(TEST_DATA_LOCALISATION + "yob" + year + "short.csv");
        String workingGender = gender.toLowerCase();
        int numberOfNames = 0;
        switch (workingGender) {
            case FEMALE:
                numberOfNames = getNumberOfFemaleNames(fr);
                break;
            case MALE:
                numberOfNames = getNumberOfMaleNames(fr);
                break;
            default:
                return "NO NAME";
        }
        if(rank <= numberOfNames) {
            int fileRank = 0;
            for (CSVRecord line : fr.getCSVParser(false)) {
                String recordGender = line.get(1).toLowerCase();
                if (recordGender.equals(workingGender) && fileRank < numberOfNames) fileRank++;
                if (fileRank == rank) {
                    return line.get(0);
                }
            }
        }
        return "NO NAME";
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender) {
        String workingName = name.toLowerCase();

        int nameRankInYearBorn = getRank(year, workingName, gender);
        String newYearName = getName(newYear, nameRankInYearBorn, gender);
        String sheHe = gender.toLowerCase().equals(FEMALE) ? "she" : "he";

        System.out.println(name + " born in " + year + " would be " + newYearName + " if " + sheHe + " was born in " + newYear);
    }
}
