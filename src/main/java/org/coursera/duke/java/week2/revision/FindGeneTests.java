package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.FindGene.findGene;
import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGeneTests {
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        //String gene = findGeneSimple(dna, "ATG", "TAA");
        String gene = findGene(dna);
        if(gene.equals("")) {
            System.out.print("Test with no valid codons inside genome passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no valid codons inside genome failed");
        }

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        gene = findGene(dna);
        if(gene.equals("ATGCCCTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "AATGCTAGGGTAATATGGT";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("ATGCTAGGGTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("ATGCTTCGGCTGCTCTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATGGGTTAAGTC";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("ATGGGTTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATGTAA";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("ATGTAA")) {
            System.out.print("Test with shortest gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with shortest gene failed");
        }

        dna = "TAATAA";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("")) {
            System.out.print("Test with no start codon passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no start codon failed");
        }

        dna = "TAAATGAAATGAATTG";
        //gene = findGeneSimple(dna, "ATG", "TAA");
        gene = findGene(dna);
        if(gene.equals("")) {
            System.out.print("Test with no end codon passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no end codon failed");
        }


    }
}
