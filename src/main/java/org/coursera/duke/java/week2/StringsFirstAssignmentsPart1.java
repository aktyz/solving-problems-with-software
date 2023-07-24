package org.coursera.duke.java.week2;

public class StringsFirstAssignmentsPart1 {
    public static String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) {
            return "";
        }
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if(endIndex == -1) {
            return "";
        }
        String resultCandidate = dna.substring(startIndex, endIndex + 3);
        if(resultCandidate.length() % 3 == 0) {
            return resultCandidate;
        }
        else return "";
    }

    public static void testSimpleGene() {
        String dna = "TAATAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna));

        dna = "ATCCTATGCTTCGGCTGCTCTCAATATGGT";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna));

        dna = "ACTGTAGA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna));

        dna = "ATGGTGCTGTAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna));

        dna = "ATGGTGTCTATAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna));
    }

    public static void main(String[] args) {
        testSimpleGene();
    }
}
