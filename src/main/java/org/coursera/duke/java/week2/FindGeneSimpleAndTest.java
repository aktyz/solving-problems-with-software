package org.coursera.duke.java.week2;

public class FindGeneSimpleAndTest {
    public String findGeneSimple (String dna, String startGenome, String endGenome) {
        // start codon is "ATG"
        // end codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        if(stopIndex == -1) {
            return "";
        }
        result = dna.substring(startIndex, stopIndex + 3);
        return result;
    }

    public void testFindGeneSimple() {
        //System.out.println(findGeneSimple("AAATGCCCTAACTAGATTAAGAAACC", "ATG", "TAA"));
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "TAATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "TAAATGAAATGAATTG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);

        dna = "ATGGGTTAAGTC";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);


//        dna = "gatgctataat";
//        System.out.println("DNA strand is " + dna);
//        gene = findGeneSimple(dna, "ATG", "TAA");
//        System.out.println("Gene is " + gene);
//        System.out.println("Gene is atgctataa");
    }
}
