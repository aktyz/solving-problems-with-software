package org.coursera.duke.java.week4;

import edu.duke.FileResource;

import static org.coursera.duke.java.week4.FileData.*;

public class Main {
    public static void main(String[] args) {
        //printNames();
        printRareNames(100);
        totalBirths(new FileResource(TEST_DATA_LOCALISATION + "example-small.csv"));
    }
}
