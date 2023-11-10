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

    public static boolean twoOccurrences(String stringA, String stringB) {
        if(stringA.equals("")) return false;
        if(stringB.contains(stringA)) {
            int firstIndex = stringB.indexOf(stringA);
            if(!(firstIndex == -1)) {
                int secondIndex = stringB.indexOf(stringA, firstIndex + stringA.length());
                if(secondIndex == -1) return false;
                else return true;
            }
        }
        return false;
    }

    //This method finds the first occurrence of stringa in stringb,
    //and returns the part of stringb that follows stringa.
    //If stringa does not occur in stringb, then return stringb.
    //
    public static String lastPart(String stringA, String stringB) {
        if(stringA.equals("")) return stringB;
        if(stringB.contains(stringA)) {
            return stringB.substring(stringB.indexOf(stringA) + stringA.length());
        }
        return stringB;
    }

}
