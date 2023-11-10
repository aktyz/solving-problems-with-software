package org.coursera.duke.java.week2.revision;

public class FindGene {
    public static final String START_CODON = "ATG";
    public static final String TAA_STOP_CODON = "TAA";
    public static final String TGA_STOP_CODON = "TGA";
    public static final String TAG_STOP_CODON = "TAG";

    public static String findGene(String dna, String startCodon, String stopCodon) {
        String result = null;
        int startCodonIndex = dna.indexOf(startCodon);
        int currentDnaIndex = dna.indexOf(stopCodon, startCodonIndex + 3);

        while (startCodonIndex <= dna.length()) {
            if(startCodonIndex == -1) return "";
            else {
                while (currentDnaIndex <= dna.length()) {
                    if (currentDnaIndex == -1) break;
                    else { // here I need to be checking for three different stopCodons
                        result = dna.substring(startCodonIndex, currentDnaIndex + 3);
                        if (result.length() % 3 == 0)
                            return result;
                        else {
                            currentDnaIndex = dna.indexOf(stopCodon, currentDnaIndex + 3);
                        }
                    }
                }
            }
            startCodonIndex = dna.indexOf(startCodon, startCodonIndex + 3);
            currentDnaIndex = dna.indexOf(stopCodon, startCodonIndex + 3);
        }
        return "";
    }

    public static int findFirstOccuringStopCodon(String dna, int startIndex) {
        return dna.length();
    }

}
