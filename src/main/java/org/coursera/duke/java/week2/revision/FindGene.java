package org.coursera.duke.java.week2.revision;

public class FindGene {
    public static final String START_CODON = "ATG";
    public static final String TAA_STOP_CODON = "TAA";
    public static final String TGA_STOP_CODON = "TGA";
    public static final String TAG_STOP_CODON = "TAG";

    public static String findGene(String dna, String startCodon) {
        String result = null;
        int atgIndex = dna.indexOf(startCodon);
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
}
