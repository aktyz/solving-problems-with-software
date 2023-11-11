package org.coursera.duke.java.week2.revision;

import edu.duke.StorageResource;

import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGene {
    public static final String START_CODON = "ATG";
    public static final String TAA_STOP_CODON = "TAA";
    public static final String TGA_STOP_CODON = "TGA";
    public static final String TAG_STOP_CODON = "TAG";

    public static final String CTG_CODON = "CTG";

    public static void printAllGenes(String dna) {
        int startIndex = 0;
        String gene = "";
        while(true) {
            gene = findGene(dna, START_CODON, startIndex);
            if(gene.isEmpty()) break;
            printGene(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }

    public static String findGene(String dna, String startCodon, int whereToStart) {
        String result = null;
        int atgIndex = dna.indexOf(startCodon, whereToStart);
        int currentDnaIndex = findFirstOccurringStopCodon(dna, atgIndex);

        while (atgIndex <= dna.length()) {
            if(atgIndex == -1) return "";
            else {
                while (currentDnaIndex <= dna.length()) {
                    if (currentDnaIndex == -1) break;
                    else {
                        result = dna.substring(atgIndex, currentDnaIndex + 3);
                        if (result.length() % 3 == 0)
                            return result;
                        else {
                            currentDnaIndex = findFirstOccurringStopCodon(dna, currentDnaIndex + 3);
                        }
                    }
                }
            }
            atgIndex = dna.indexOf(startCodon, atgIndex + 3);
            currentDnaIndex = findFirstOccurringStopCodon(dna, atgIndex + 3);
        }
        return "";
    }

    public static int findFirstOccurringStopCodon(String dna, int startIndex) {

        int taaIndex = findStopCodon(dna, startIndex, TAA_STOP_CODON);
        int tgaIndex = findStopCodon(dna, startIndex, TAG_STOP_CODON);
        int tagIndex = findStopCodon(dna, startIndex, TGA_STOP_CODON);

        int temp = Math.min(taaIndex, tgaIndex);
        int minIndex = Math.min(temp, tagIndex);
        return minIndex == dna.length() ? -1 : minIndex;
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int result = dna.indexOf(stopCodon, startIndex);
        return (result == -1) ? dna.length() : result;
    }

    public static int countGenes(String dna) {
        int startIndex = 0;
        int geneCount = 0;
        String gene = "";
        while(true) {
            gene = findGene(dna, START_CODON, startIndex);
            if(gene.isEmpty()) break;
            geneCount++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneCount;
    }

    public static StorageResource storeGenes(String dna) {
        int startIndex = 0;
        StorageResource sr = new StorageResource();
        String currentDna = dna.toUpperCase();
        while(true) {
            String currentGene = findGene(currentDna, START_CODON, startIndex);
            if(currentGene.isEmpty()) break;
            sr.add(currentGene);
            startIndex = currentDna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return sr;
    }
}
