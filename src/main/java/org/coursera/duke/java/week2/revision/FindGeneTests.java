package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.FindGene.*;
import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGeneTests {
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        String gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Test with no valid codons inside genome passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no valid codons inside genome failed");
        }

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCCCTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "AATGCTAGGGTAATATGGT";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCTAGGGTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCTTCGGCTGCTCTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATGGGTTAAGTC";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGGGTTAA")) {
            System.out.print("Test with valid gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with valid gene failed");
        }

        dna = "ATGTAA";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGTAA")) {
            System.out.print("Test with shortest gene passed - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Test with shortest gene failed");
        }

        dna = "TAATAA";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Test with no start codon passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no start codon failed");
        }

        dna = "TAAATGAAATGAATTG";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Test with no end codon passed - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Test with no end codon failed");
        }


    }
}
