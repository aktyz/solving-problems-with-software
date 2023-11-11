package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.FindGene.CTG_CODON;

public class Utils {
    public static void printGene(String gene) {
        if(!gene.equals("")) {
            System.out.print(gene.substring(0, 3) + " ");
            divideToTriplets(gene.substring(3, gene.length() - 3));
            System.out.print(gene.substring(gene.length() - 3));
        }
        System.out.println();
    }

    public static float cgRatio(String dna) {
        if(dna.length() == 0) return 0;
        else {
            int cgCount = 0;
            String currentDna = dna.toUpperCase();
            while (currentDna.contains("C")) {
                currentDna = currentDna.substring(currentDna.indexOf("C") + 1);
                cgCount++;
            }
            currentDna = dna.toUpperCase();
            while (currentDna.contains("G")) {
                currentDna = currentDna.substring(currentDna.indexOf("G") + 1);
                cgCount++;
            }
            return (float) cgCount/dna.length();
        }
    }

    public static int countCTG(String dna) {
        if(dna.length() == 0) return 0;
        else {
            int ctgCount = 0;
            String currentDna = dna.toUpperCase();
            while(currentDna.contains(CTG_CODON)) {
                currentDna = currentDna.substring(currentDna.indexOf(CTG_CODON) + CTG_CODON.length());
                ctgCount++;
            }
            return ctgCount;
        }
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

    public static String lastPart(String stringA, String stringB) {
        if(stringA.equals("")) return stringB;
        if(stringB.contains(stringA)) {
            return stringB.substring(stringB.indexOf(stringA) + stringA.length());
        }
        return stringB;
    }

    public static int howMany(String stringA, String stringB) {
        if(stringA.isEmpty() || stringB.isEmpty()) return 0;
        int occurrences = 0;
        while(stringB.contains(stringA)) {
            stringB = stringB.substring(stringB.indexOf(stringA) + stringA.length());
            occurrences++;
        }
        return occurrences;
    }
}
