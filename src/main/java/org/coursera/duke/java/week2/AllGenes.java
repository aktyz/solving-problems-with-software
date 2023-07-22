package org.coursera.duke.java.week2;

public class AllGenes {
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
        while(currentIndex != -1) {
            if((currentIndex - startIndex) % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return dna.length();
    }

    public static String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(Math.min(taaIndex, tagIndex), tgaIndex);
        if (minIndex == dna.length()) return "";
        else return dna.substring(startIndex, minIndex + 3);
    }

    public static void testFindStopCodon() {
        //            *  *  *  *  *  *  *  *  *  *
        String dna = "xxxxyyyyzzzzTAAzzzyyyxxxTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if(dex != 12) System.out.println("error on 12");

        dex = findStopCodon(dna, 12, "TAA");
        if(dex != 24) System.out.println("error on 27");

        dex = findStopCodon(dna, 1, "TAA");
        if(dex != 29) System.out.println("error on dna.length()");

        dex = findStopCodon(dna, 0, "TAG");
        if(dex != 29) System.out.println("error on dna.length()");
        System.out.println("testFindStopCodon finished!");
    }

    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        if(!findGene(dna).equals("")) System.out.println("Error on first case");

        dna = "AATGCTAGGGTAATATGGT";
        if(!findGene(dna).equals("ATGCTAGGGTAA")) System.out.println("Error on second case");

        dna = "AATGCTAGGTAATTGAGT";
        if(!findGene(dna).equals("ATGCTAGGTAATTGA")) System.out.println("Error on third case");

        dna = "AATGCTAGGTAATCTGAGT";
        if(!findGene(dna).equals("")) System.out.println("Error on fourth case");

        dna = "AATCGCTAGGTAATCTGAGT";
        if(!findGene(dna).equals("")) System.out.println("Error on fifth case");

        System.out.println("testFindGene finished!");
    }
    public static void main(String[] args) {
        testFindStopCodon();
        testFindGene();
    }
}
