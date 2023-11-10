package org.coursera.duke.java.week2.revision;

public class Utils {
    public static void printGene(String gene) {
        if(!gene.equals("")) {
            System.out.print(gene.substring(0, 3) + " ");
            divideToTriplets(gene.substring(3, gene.length() - 3));
            System.out.print(gene.substring(gene.length() - 3));
        }
        System.out.println();
    }

    private static void divideToTriplets(String dna) {
        if(!dna.equals("")) {
            for(int i = 0; i < dna.length(); i = i + 3) {
                System.out.print(dna.substring(i, i + 3) + " ");
            }
        }
    }
}
