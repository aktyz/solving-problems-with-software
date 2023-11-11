package org.coursera.duke.java.week2.revision;

import edu.duke.StorageResource;

import static org.coursera.duke.java.week2.revision.FindGene.*;
import static org.coursera.duke.java.week2.revision.Utils.printGene;

public class FindGeneTests {
    public static void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        String gene = findGene(dna, START_CODON, 0);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no valid codons inside genome - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no valid codons inside genome");
        }

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCCCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "AATGCTAGGGTAATATGGT";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCTAGGGTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCTTCGGCTGCTCTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGGGTTAAGTC";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGGGTTAA")) {
            System.out.print("Passed: Test with valid gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with valid gene");
        }

        dna = "ATGTAA";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGTAA")) {
            System.out.print("Passed: Test with shortest gene - Gene is: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with shortest gene");
        }

        dna = "TAATAA";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no start codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.println("Failed: Test with no start codon");
        }

        dna = "TAAATGAAATCAATTG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("")) {
            System.out.print("Passed: Test with no end codon - Gene is empty: ");
            printGene(gene);
        } else {
            System.out.print("Failed: Test with no end codon, gene found: ");
            printGene(gene);
        }

        dna = "ATGATCGCTAATGCTTAAGCTATG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGATCGCTAATGCTTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon repeats");

        dna = "ATGGGACTAAATGCCGTAA";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCCGTAA")) {
            System.out.print("Passed: Found gene despite ATG startCodon repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when startCodon repeats, dna: " + dna);

        dna = "ATGATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGATGGCTAATGCTAAGTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);

        dna = "ATGCATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCATGGCTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);

        dna = "ATGCGATGGCTAATGCTAAGTAAGCTATG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGGCTAATGCTAAGTAA")) {
            System.out.print("Passed: Found gene despite TAA stopCodon repetition and ATG gene repetition, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when stopCodon and startCodon repeat, dna: " + dna);
        
        dna = "ATGATCGCTGATTAGGCTTAAATTGACG";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGATCGCTGATTAG")) {
            System.out.print("Passed: Found gene despite when three different stopCodons available, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find the correct gene when when three different stopCodons available, dna: " + dna);

        dna = "CCAGTAATGCCGTAGCCCGACTTA";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCCGTAG")) {
            System.out.print("Passed: Correctly identified gene ending with TAG stopCodon, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find gene ending with TAG stopCodon");

        dna = "CCGTAAATGCCGCTAAGTTGATAAGCT";
        gene = findGene(dna, START_CODON, 0);
        if(gene.equals("ATGCCGCTAAGTTGA")) {
            System.out.print("Passed: Correctly identified gene ending with TGA stopCodon, gene: ");
            printGene(gene);
        } else System.out.println("Failed: Function did not find gene ending with TGA stopCodon");

        dna = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA"; // two genes string
        System.out.println("Two genes should be printed out:");
        printAllGenes(dna);
        int geneCount = countGenes(dna);
        if(geneCount == 2) System.out.println("Passed: correctly counted two genes");
        else System.out.println("Failed: FindGene.countGenes() couldn't count genes correctly, geneCount: " + geneCount);
        System.out.println();
        //            ATG   TAA  ATG   v  v  TGA
        dna = "ATGctgTAAtaATGCTGCAACGGTGAAGA";
        System.out.println("Two genes should be printed out:");
        printAllGenes(dna);
        geneCount = countGenes(dna);
        if(geneCount == 2) System.out.println("Passed: correctly counted two genes");
        else System.out.println("Failed: FindGene.countGenes() couldn't count genes correctly, geneCount: " + geneCount);
        System.out.println();
        //     ATG   v  v  v  TAA   v  v  ATGTAA
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("Two genes should be printed out:");
        printAllGenes(dna);
        geneCount = countGenes(dna);
        if(geneCount == 2) System.out.println("Passed: correctly counted two genes");
        else System.out.println("Failed: FindGene.countGenes() couldn't count genes correctly, geneCount: " + geneCount);
        System.out.println();
        dna = "TAATAGTGAGCA";
        System.out.println("No genes should be printed out:");
        printAllGenes(dna);
        geneCount = countGenes(dna);
        if(geneCount == 0) System.out.println("Passed: correctly counted no genes");
        else System.out.println("Failed: FindGene.countGenes() couldn't count genes correctly in no genes string, geneCount: " + geneCount);
        System.out.println();

        System.out.println("StorageResource testing");
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        StorageResource sr = storeGenes(dna);
        for(String s : sr.data()) {
            printGene(s);
        }
        System.out.println();
    }
}
