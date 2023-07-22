package org.coursera.duke.java.week2;

public class StringsFirstAssignmentsPart2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        int startIndex = dna.toUpperCase().indexOf(startCodon.toUpperCase());
        if(startIndex == -1) {
            return "";
        }
        int endIndex = dna.toUpperCase().indexOf(stopCodon.toUpperCase(), startIndex + 3);
        if(endIndex == -1) {
            return "";
        }
        String resultCandidate = dna.substring(startIndex, endIndex + 3);
        if(resultCandidate.length() % 3 == 0) {
            return resultCandidate;
        }
        else return "";
    }

    public void testSimpleGene() {
        String dna = "TAATAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));

        dna = "ATCCTATGCTTCGGCTGCTCTCAATATGGT";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));

        dna = "ACTGTAGA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));

        dna = "ATGGTGCTGTAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));

        dna = "ATGGTGTCTATAA";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));

        dna = "gatgctataat";
        System.out.println("String is: " + dna);
        System.out.println("Gene found: " + findSimpleGene(dna, "ATG", "TAA"));
    }
}
