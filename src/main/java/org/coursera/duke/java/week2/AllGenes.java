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
        return -1;
    }

    public static String findGene(String dna, int startIndex) {
        int atgIndex = dna.indexOf("ATG", startIndex);
        if (atgIndex == -1) return "";
        int taaIndex = findStopCodon(dna, atgIndex, "TAA");
        int tagIndex = findStopCodon(dna, atgIndex, "TAG");
        int tgaIndex = findStopCodon(dna, atgIndex, "TGA");
        int minIndex;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) minIndex = tgaIndex;
        else minIndex = taaIndex;
        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) minIndex = tagIndex;

        if (minIndex == -1) return "";
        else return dna.substring(atgIndex, minIndex + 3);
    }

    public static void printAllGenes(String dna) {
        int startIndex = 0;
        String geneFound;
        while( true ) {
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

    public static void testPrintAllGenes() {
        //            ATG   TAA  ATG   v  v  TGA
        String dna = "ATGctgTAAtaATGCTGCAACGGTGAAGA";
        System.out.println("Testing printAllGenes on: " + dna);
        printAllGenes(dna);
        dna = "";
        System.out.println("Testing printAllGenes on: " + dna);
        printAllGenes(dna);
        //     ATG   v  v  v  TAA   v  v  ATGTAA
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("Testing printAllGenes on: " + dna);
        printAllGenes(dna);

    }

    public static void runAllTests() {
        testFindStopCodon();
        testFindGene();
        testPrintAllGenes();
    }
}
