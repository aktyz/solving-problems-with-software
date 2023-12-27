package org.coursera.duke.java.week4;

import static org.coursera.duke.java.week4.FileData.*;

public class FileDataTest {
    public static void testGetRank() {
        int result = getRank(2012,"Mason","M");
        if(result == 2) System.out.println("Passed: correctly calculated Mason's boy rank in 2012 test file: " + result);
        else System.out.println("Failed: FileData.getRank() failed to calculate Mason's boy rank in 2012: " + result);

        result = getRank(2012, "Mason", "F");
        if(result == -1) System.out.println("Passed: correctly calculated Mason's girl rank in 2012 test file: " + result);
        else System.out.println("Failed: FileData.getRank() failed to calculate Mason's girl rank in 2012: " + result);

        result = getRank(2012, "Zyta", "F");
        if(result == -1) System.out.println("Passed: correctly calculated Zyta's girl rank in 2012 test file: " + result);
        else System.out.println("Failed: FileData.getRank() failed to calculate Zyta's girl rank in 2012: " + result);

        result = getRank(2012, "Mason", "Z");
        if(result == -1) System.out.println("Passed: correctly identified wrong function input");
        else System.out.println("Failed: FileData.getRank() will fail due to the wrong function input not identified");


        /** Test cases to add:
         * getRank(1971,"Frank", "m").equals(54) is true - there's girl name Frank in this year that breaks the algorithm
         * String girl350in1980 = getName(1980, 350, "f"); - should equal to MIA (?), returns "NO NAME"
         * String boy450in1982 = getName(1982, 450, "m"); - returns "NO NAME"
         * */
    }

    public static void testGetName() {
        String fileName = getName(2012,3, "F");
        if(fileName.equals("Isabella")) System.out.println("Passed: correctly got the rank name");
        else System.out.println("Failed: FileData.getName() couldn't find Isabella, found instead: " + fileName);

        fileName = getName(2012, 5, "M");
        if(fileName.equals("William")) System.out.println("Passed: correctly got the rank name");
        else System.out.println("Failed: FileData.getName() couldn't find William, found instead: " + fileName);

        fileName = getName(2012, 37, "M");
        if(fileName.equals("NO NAME")) System.out.println("Passed: correctly got out of scope rank");
        else System.out.println("Failed: FileData.getName() found non existing rank name: " + fileName);
    }

    public static void testWhatIsNameInYear() {
        whatIsNameInYear("Isabella",2012, 2014, "F");
    }

    public static void testYearOfHighestRank() {
        System.out.println("Mason was most popular in " + yearOfHighestRank("Mason", "M") + " year");
        // Mason was most popular in 2012 year
        System.out.println("Sophia was most popular in " + yearOfHighestRank("Sophia", "F") + " year");
        // Sophia was most popular in 2012 year
        System.out.println("Zyta was most popular in " + yearOfHighestRank("Zyta", "F") + " year");
        // Zyta was most popular in -1 year
        System.out.println("Liam was most popular in " + yearOfHighestRank("Liam", "M") + " year");
        // Liam was most popular in 2013 year
        System.out.println("Ethan was most popular in " + yearOfHighestRank("Ethan", "M") + " year");
        // Ethan was most popular in 2012 year
    }

    public static void testGetAverageRank() {
        double result = getAverageRank("Mason", "M");
        if(result == 3.0) System.out.println("Passed: Mason's average rank calculated correctly: " + result);
        else System.out.println("Failed: FileData.getAverageRank() failed to calculate Mason's average rank correctly: " + result);

        result = getAverageRank("Jacob", "M");
        if(result == (double) 8/3) System.out.println("Passed: Jacob's average rank calculated correctly: " + result);
        else System.out.println("Failed: FileData.getAverageRank() failed to calculate Jacob's average rank correctly: " + result);

        result = getAverageRank("Sophia", "F");
        if(result == (double) 5/3) System.out.println("Passed: Sophia's average rank calculated correctly: " + result);
        else System.out.println("Failed: FileData.getAverageRank() failed to calculate Sophia's average rank correctly: " + result);
    }

    public static void testGetTotalBirthsRankedHigher() {
        int result = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        if(result == 15) System.out.println("Passed: Total boys with more popular names than Ethan born in 2012 is " + result);
        else System.out.println("Failed: FileData.getTotalBirthsRankedHigher() failed to calculate number of births more popular than Ethan, result: " + result);

        result = getTotalBirthsRankedHigher(2014, "Zyta", "F");
        if(result == 18) System.out.println("Passed: Total girls with more popular names than Zyta born in 2014 is " + result);
        else System.out.println("Failed: FileData.getTotalBirthsRankedHigher() failed to calculate number of births more popular than Zyta, result: " + result);

    }
}
