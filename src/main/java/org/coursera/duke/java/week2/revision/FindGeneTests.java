package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.FindGene.*;
import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGeneTests {
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        String gene = findGene(dna, START_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no valid codons inside genome - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no valid codons inside genome");
        }

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCCCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "AATGCTAGGGTAATATGGT";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCTAGGGTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCTTCGGCTGCTCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGGGTTAAGTC";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGGGTTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGTAA";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGTAA")) {
            System.out.print("Passed: Test with shortest gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with shortest gene");
        }

        dna = "TAATAA";
        gene = findGene(dna, START_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no start codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no start codon");
        }

        dna = "TAAATGAAATCAATTG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no end codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.print("Failed: Test with no end codon, gene found: ");
            printGene(gene);
        }

        dna = "ATGATCGCTAATGCTTAAGCTATG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGATCGCTAATGCTTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon repeats");

        dna = "ATGGGACTAAATGCCGTAA";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCCGTAA")) {
            System.out.print("Passed: Found gene despite ATG startCodon repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when startCodon repeats, dna: " + dna);

        dna = "ATGATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGATGGCTAATGCTAAGTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);

        dna = "ATGCATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCATGGCTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);

        dna = "ATGCGATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGGCTAATGCTAAGTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);
        
        dna = "ATGATCGCTGATTAGGCTTAAATTGACG";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGATCGCTGATTAG")) {
            System.out.print("Passed: Found gene despite when three different stopCodons available, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when when three different stopCodons available, dna: " + dna);

        dna = "CCAGTAATGCCGTAGCCCGACTTA";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCCGTAG")) {
            System.out.print("Passed: Correctly identified gene ending with TAG stopCodon, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find gene ending with TAG stopCodon");

        dna = "CCGTAAATGCCGCTAAGTTGATAAGCT";
        gene = findGene(dna, START_CODON);
        if(gene.equals("ATGCCGCTAAGTTGA")) {
            System.out.print("Passed: Correctly identified gene ending with TGA stopCodon, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find gene ending with TGA stopCodon");
    }
}
