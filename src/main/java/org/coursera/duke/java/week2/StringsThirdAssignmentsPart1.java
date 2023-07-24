package org.coursera.duke.java.week2;

import edu.duke.StorageResource;

import static org.coursera.duke.java.week2.AllGenes.findGene;

public class StringsThirdAssignmentsPart1 {
    public static StorageResource getAllGenes(String dna) {
        StorageResource allGenes = new StorageResource();
        int startIndex = 0;
        String geneFound;
        while(true) {
            geneFound = findGene(dna, startIndex);
            if(geneFound.isEmpty()) break;
            allGenes.add(geneFound);
            startIndex = dna.indexOf(geneFound, startIndex) + geneFound.length();
        }
        return allGenes;
    }
    public static void main(String[] args) {
        String dna = "AATGCTAGGTAATTGAGT";
        StorageResource result = getAllGenes(dna);
        for(String s : result.data()) {
            System.out.println(s);
        }
    }
}
