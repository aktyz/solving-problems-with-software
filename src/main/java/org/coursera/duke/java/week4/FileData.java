package org.coursera.duke.java.week4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class FileData {

    public static final String FEMALE = "f";
    public static final String MALE = "m";
    public static final String TEST_DATA_LOCALISATION = "resources/week4/us_babynames_test/";

    public static final String BABYNAMES_BY_YEAR = "resources/week4/us_babynames_by_year/";
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
        FileResource fr = new FileResource(BABYNAMES_BY_YEAR + "yob" + year + ".csv");
        CSVParser parser = fr.getCSVParser(false);
        String workingName = name.toLowerCase();
        String workingGender = gender.toLowerCase();
        int numberOfNamesForWorkingGender = getNumberOfNamesByGender(workingGender, fr);
        int rank = 0;

        String lineGender = null;
        String lineName = null;

        for (CSVRecord line : parser) {
            lineGender = line.get(1).toLowerCase();
            lineName = line.get(0).toLowerCase();
            if(rank <= numberOfNamesForWorkingGender && lineGender.equals(workingGender)) {
                rank ++;
                if(lineName.equals(workingName))
                    return rank;
            }
        }
        if(rank == numberOfNamesForWorkingGender) return -1;
        return rank == 0 ? -1 : rank;
    }

    public static int getNumberOfNamesByGender(String workingGender, FileResource fr) {
        switch (workingGender) {
            case FEMALE:
                return getNumberOfFemaleNames(fr);
            case MALE:
                return getNumberOfMaleNames(fr);
            default:
                return -1;
        }
    }

    public static String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource(BABYNAMES_BY_YEAR + "yob" + year + ".csv");
        String workingGender = gender.toLowerCase();
        if(workingGender.equals(FEMALE) || workingGender.equals(MALE)) {
            int numberOfNames = getNumberOfNamesByGender(workingGender, fr);
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

    public static int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestRanking = -1;
        int yearOfHighestRank = -1;
        String workingName = name.toLowerCase();
        String workingGender = gender.toLowerCase();

        for(File f : dr.selectedFiles()) {
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int currentRanking = getRank(year, workingName, workingGender);
            if (currentRanking == -1) continue;
            else if(highestRanking == -1) {
                highestRanking = currentRanking;
                yearOfHighestRank = year;
            } else if (currentRanking < highestRanking) {
                highestRanking = currentRanking;
                yearOfHighestRank = year;
            }
        }
        return yearOfHighestRank;
    }

    public static double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        String workingName = name.toLowerCase();
        String workingGender = gender.toLowerCase();
        int numberOfFiles = 0;
        int totalOfRanks = 0;
        for(File f : dr.selectedFiles()) {
            numberOfFiles++;
            int year = Integer.parseInt(f.getName().substring(3, 7));
            int fileRank = getRank(year, workingName, workingGender);
            if(fileRank != -1) {
                totalOfRanks += fileRank;
            }
        }
        if(numberOfFiles != 0) return (double) totalOfRanks / numberOfFiles;
        else return -1.0;
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirthsRankedHigher = 0;
        FileResource fr = new FileResource(BABYNAMES_BY_YEAR + "yob" + year + ".csv");
        String workingName = name.toLowerCase();
        String workingGender = gender.toLowerCase();
        for (CSVRecord line : fr.getCSVParser(false)) {
            if(workingGender.equals(line.get(1).toLowerCase())) {
                if(workingName.equals(line.get(0).toLowerCase())) break;
                totalBirthsRankedHigher += Integer.parseInt(line.get(2));
            }
        }
        return totalBirthsRankedHigher;
    }
}
