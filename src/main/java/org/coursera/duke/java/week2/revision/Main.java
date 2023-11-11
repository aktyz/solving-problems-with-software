package org.coursera.duke.java.week2.revision;

import edu.duke.FileResource;
import edu.duke.StorageResource;

import static org.coursera.duke.java.week2.revision.FindGene.storeGenes;
import static org.coursera.duke.java.week2.revision.Utils.countCTG;

public class Main {

    // Programming Exercise: Storing All Genes
    public static void processGenes(StorageResource sr) {
        processSRGenesLongerThan(sr, 60);
        System.out.println();
        processSRGenesCgRatioGreaterThan(sr, (float) 0.35);
        System.out.println();
        printAllSRGenes(sr);
        longestSRGene(sr);
        String dna = "TAGTAGTAGTTT";
        dna = mystery(dna);
        System.out.println("Mystery dna: " + dna);
    }

    private static void longestSRGene(StorageResource sr) {
        int currentLength = 0;
        for(String s : sr.data()) {
            if(s.length() > currentLength) currentLength = s.length();
        }
        System.out.println("Length of the longest gene found in the SR: " + currentLength);
    }

    public static void processSRGenesLongerThan(StorageResource sr, int numberOfChar) {
        int count = 0;
        System.out.println("Printing Genes longer than " + numberOfChar + ":");
        for(String s : sr.data()) {
            if(s.length()>numberOfChar) {
//                System.out.print(count + 1 + ": ");
//                printGene(s);
                count++;
            }
        }
        System.out.println("Number of Genes longer than " + numberOfChar + ":" + count);
    }

    public static void processSRGenesCgRatioGreaterThan(StorageResource sr, float cgRatio) {
        int count = 0;
        System.out.println("Printing Genes with cgRation greater than:" + cgRatio);
        for(String s : sr.data()) {
            if(Utils.cgRatio(s) > cgRatio) {
//                System.out.print(count + 1 + ": ");
//                printGene(s);
                count++;
            }
        }
        System.out.println("Number of Genes with cgRation greater than " + cgRatio + " is " + count);
    }

    public static void printAllSRGenes(StorageResource sr) {
        int count = 0;
        System.out.println("Printing all SR genes:");
        for(String s : sr.data()) {
//            System.out.print(count + 1 + ": ");
//            printGene(s);
            count++;
        }
        System.out.println("Number of Genes in SR: " + count);
    }
    public static void main(String[] args) {
        FileResource fr = new FileResource("resources/week2/GRch38dnapart.fa");
        String dna = fr.asString();
        System.out.println("Number of CTG codons in DNA Strand: " + countCTG(dna));
        StorageResource sr = storeGenes(dna);
        processGenes(sr);
    }

    public static String mystery(String dna) {
        int pos = dna.indexOf("T");
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }
}
