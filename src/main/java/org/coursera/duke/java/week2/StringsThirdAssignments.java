package org.coursera.duke.java.week2;

import edu.duke.FileResource;
import edu.duke.StorageResource;

import java.util.ArrayList;

import static org.coursera.duke.java.week2.AllGenes.findGene;

public class StringsThirdAssignments {
    public static StorageResource getAllGenes(String dna) {
        StorageResource allGenes = new StorageResource();
        int startIndex = 0;
        String geneFound;
        while(true) {
            geneFound = findGene(dna, startIndex);
            if(geneFound.isEmpty()) break;
            allGenes.add(geneFound);
            startIndex = dna.indexOf(geneFound, startIndex) + geneFound.length();
        }
        return allGenes;
    }

    public static double countCTG(String dna) {
        if(dna.isEmpty()) return -1.0;
        int numberOfCs = countOccurrences(dna, "C");
        int numberOfGs = countOccurrences(dna, "G");
        double sum = (double) numberOfGs + (double) numberOfCs;
        return sum/dna.length();
    }

    public static int countOccurrences(String dna, String x) {
        int count = 0;
        int index = dna.indexOf(x);
        while(index != -1) {
            count ++;
            index = dna.indexOf(x, index + 1);
        }
        return count;
    }

    public static void processGenes(StorageResource sr) {
        int countLength = 0;
        int countCGRatio = 0;
        int longestLength = 0;
        for(String s : sr.data()) {
            System.out.println();
            System.out.println("String longer than 60 chars:");
            if(s.length() > 60) {
                countLength ++;
                System.out.println(s);
            }
            System.out.println("String whose C-G-ratio is higher than 0.35:");
            if(countCTG(s) > 0.35) {
                countCGRatio++;
                System.out.println(s);
            }
            if(s.length() > longestLength) longestLength = s.length();
        }
        System.out.println();
        System.out.println("Number of strings longer than 60 chars: " + countLength);
        System.out.println("Number of strings with C-G-ratio higher than 0.35: " + countCGRatio);
        System.out.println("Length of longest gene in the file: " + longestLength);
        System.out.println();
    }
    public static void testCountCTG() {
        String dna = "ATGCCATAG";
        if(countCTG(dna) != (double) 4 / (double) 9) System.out.println("First test case failed!");

        System.out.println("Testing of countCTG() completed!");
    }

    public static void testCountOccurrences() {
        int result = countOccurrences("CCC", "C");
        if(result != 3) System.out.println("First test case failed!");

        result = countOccurrences("", "G");
        if(result != 0) System.out.println("Second test case failed!");

        System.out.println("Testing of countOccurrences() completed!");
    }

    public static void testProcessGenes() {
        ArrayList<String> dnas = new ArrayList<>();
        dnas.add("ATGCATGCACTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGC");
        dnas.add("ACGTACGTACGTACGTACGT");
        dnas.add("ATGCCGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTA");
        dnas.add("ATGCTATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTA");
        dnas.add("ATGCATGCATATATATCGCGCGCGCGCGCGCGCGCGCGCGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTAGCTATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATATAT");
        StorageResource sr = new StorageResource();
        for(String dna : dnas) {
            sr = getAllGenes(dna);
            processGenes(sr);
            sr.clear();
        }
    }

    public static void testAll() {
        testCountOccurrences();
        testCountCTG();
        testProcessGenes();
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource("resources/week2/brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = new StorageResource();
        sr.add(dna);
        processGenes(sr);
    }
}
