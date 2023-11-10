package org.coursera.duke.java.week2.revision;

public class FindGene {
    public static final String START_CODON = "ATG";
    public static final String TAA_STOP_CODON = "TAA";

    public static String findGene(String dna) {
        String result = null;
        int startCodonIndex = dna.indexOf(START_CODON);
        if(startCodonIndex == -1) return "";
        int taaStopCodonIndex = dna.indexOf(TAA_STOP_CODON, startCodonIndex + 3);
        if(taaStopCodonIndex == -1) return "";
        result = dna.substring(startCodonIndex, taaStopCodonIndex + 3);
        return result.length() % 3 == 0 ? result : "";
    }

}
