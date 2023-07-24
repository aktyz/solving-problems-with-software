package org.coursera.duke.java.week2;

import static org.coursera.duke.java.week2.StringsSecondAssignmentsPart1.findGene;

public class StringsSecondAssignmentsPart3 {
    public static int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        String geneFound;
        while(true) {
            geneFound = findGene(dna, startIndex);
            if(geneFound.isEmpty()) break;
            count ++;
            startIndex = dna.indexOf(geneFound, startIndex) + geneFound.length();
        }
        return count;
    }

    public static void testCountGenes() {
        int result = countGenes("ATGTAAGATGCCCTAGT");
        /**
         * start looking for gene from the beginning of the dna
         * gene found at index 0, increase count
         * start looking for gene from the 0 + first gene.length()
         * gene found at index 7, increase count
         * start looking for gene from 7 + second gene.length()
         * no gene found, break the loop
         */
        if(result != 2) System.out.println("Error in first case!");

        result = countGenes("");
        if(result != 0) System.out.println("Error in second case!");

        result = countGenes("ksdfksjdhiuwerbnkjhivuxf");
        if(result != 0) System.out.println("Error in third case!");

        result = countGenes("ksdfATGksjdhiuwerbnkjhivuxf");
        if(result != 0) System.out.println("Error in fourth case!");

        result = countGenes("ksdfksjdhiuwerbnkjhTAAivuxf");
        if(result != 0) System.out.println("Error in fifth case!");

        result = countGenes("ksdfTAGksjdhiuwerbnATGkjhivuxf");
        if(result != 0) System.out.println("Error in sixth case!");

        System.out.println("Testing countGenes() completed!");
    }
    public static void main(String[] args) {
        // Quiz use case:
        int result = countGenes("");
        System.out.println("Number of genes found in your case: " + result);
        testCountGenes();
    }
}
