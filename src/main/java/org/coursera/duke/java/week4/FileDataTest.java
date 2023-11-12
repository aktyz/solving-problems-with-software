package org.coursera.duke.java.week4;

import static org.coursera.duke.java.week4.FileData.getName;
import static org.coursera.duke.java.week4.FileData.getRank;

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
}
