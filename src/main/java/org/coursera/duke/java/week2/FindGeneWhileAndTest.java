package org.coursera.duke.java.week2;

public class FindGeneWhileAndTest {
    public static String findGeneWhile(String dna, String startCodon, String stopCodon) {
        // Find first occurrence of "ATG" and call its index startIndex
        int startIndex = dna.indexOf(startCodon);
        // Find the "TAA" starting from (startIndex + 3), call it stopIndex
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
        // As long as currentIndex is not equal to -1
        while(currentIndex != -1) {
            // Check if (currentIndex - startIndex)%3 == 0
            if((currentIndex - startIndex) % 3 == 0) {
                // If so, the text between the startIndex and currentIndex + 3 is a valid gene
                return dna.substring(startIndex, currentIndex + 3);
            } else {
                // If not, update currentIndex to the next "TAA" occurrence
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        // Your answer is the empty string
        return "";
    }

    public static void testFindGeneWhile() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "TAATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "TAAATGAAATGAATTG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATGGGTTAAGTC";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATGGCGTTAAGTC";
        System.out.println("DNA strand is " + dna);
        gene = findGeneWhile(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
    }

    public static void main(String[] args) {
        testFindGeneWhile();
    }

}
