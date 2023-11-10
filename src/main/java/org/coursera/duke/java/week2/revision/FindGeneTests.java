package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.FindGene.*;
import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGeneTests {
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        String gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no valid codons inside genome - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no valid codons inside genome");
        }

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCCCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "AATGCTAGGGTAATATGGT";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCTAGGGTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGCTTCGGCTGCTCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGGGTTAAGTC";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGGGTTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGTAA";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("ATGTAA")) {
            System.out.print("Passed: Test with shortest gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with shortest gene");
        }

        dna = "TAATAA";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no start codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no start codon");
        }

        dna = "TAAATGAAATGAATTG";
        gene = findGene(dna, START_CODON, TAA_STOP_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no end codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no end codon");
        }


    }
}
