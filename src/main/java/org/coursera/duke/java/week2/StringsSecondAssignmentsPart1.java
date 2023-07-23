package org.coursera.duke.java.week2;

public class StringsSecondAssignmentsPart1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
        while(currentIndex != -1) {
            int diff = currentIndex - startIndex;
            if(diff % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return -1;
    }

    public static String findGene(String dna, int beginning) {
        int startIndex = dna.indexOf("ATG", beginning);
        if (startIndex == -1) return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = 0;
        if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) minIndex = tagIndex;
        else minIndex = taaIndex;
        if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) minIndex = tgaIndex;
        if(minIndex == -1) return "";
        return dna.substring(startIndex, minIndex + 3);
    }

    public static void printAllGenes(String dna) {
        int startIndex = 0;
        String geneFound;
        while(true) {
            geneFound = findGene(dna, startIndex);
            if(geneFound.isEmpty()) break;
            System.out.println(geneFound);
            startIndex = dna.indexOf(geneFound, startIndex) + geneFound.length();
        }

    }

    public static void testFindStopCodon() {
        //            *  *  *  *  *  *  *  *  *  *
        String dna = "xxxxyyyyzzzzTAAzzzyyyxxxTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if(dex != 12) System.out.println("error on 12");

        dex = findStopCodon(dna, 12, "TAA");
        if(dex != 24) System.out.println("error on 24");

        dex = findStopCodon(dna, 1, "TAA");
        if(dex != -1) System.out.println("error on dna.length()");

        dex = findStopCodon(dna, 0, "TAG");
        if(dex != -1) System.out.println("error on dna.length()");

        dna = "";
        dex = findStopCodon(dna, 0, "TAG");
        if(dex != -1) System.out.println("error on empty string");

        dna = "xxxxyyyyzzzz";
        dex = findStopCodon(dna, 1, "TGA");
        if(dex != -1) System.out.println("error on string with no genes");
        System.out.println("testFindStopCodon finished!");
    }
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        if(!findGene(dna,0).equals("")) System.out.println("Error on first case");

        dna = "AATGCTAGGGTAATATGGT";
        if(!findGene(dna,0).equals("ATGCTAGGGTAA")) System.out.println("Error on second case");

        dna = "AATGCTAGGTAATTGAGT";
        if(!findGene(dna,0).equals("ATGCTAGGTAATTGA")) System.out.println("Error on third case");

        dna = "AATGCTAGGTAATCTGAGT";
        if(!findGene(dna,0).equals("")) System.out.println("Error on fourth case");

        dna = "AATCGCTAGGTAATCTGAGT";
        if(!findGene(dna,0).equals("")) System.out.println("Error on fifth case");

        System.out.println("testFindGene finished!");
    }

    public static void main(String[] args) {
        testFindStopCodon();
        testFindGene();
    }
}
