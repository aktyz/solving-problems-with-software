package org.coursera.duke.java.week2.revision;

import static org.coursera.duke.java.week2.revision.Utils.*;

public class UtilsTests {
    public static void testUtils() {
        boolean result = twoOccurrences("by", "A story by Abby Long");
        if(result == true) System.out.println("Passed: Two occurrences correctly found");
        else System.out.println("Failed: Utils.twoOccurrences() failed to find two occurrences");

        result = twoOccurrences("a", "banana");
        if(result == true) System.out.println("Passed: At least two occurrences correctly found");
        else System.out.println("Failed: Utils.twoOccurrences() failed to find at least two occurrences");

        result = twoOccurrences("atg", "ctgtatgta");
        if(result == false) System.out.println("Passed: Only one occurrence therefore function returns false");
        else System.out.println("Failed: Utils.twoOccurrences() found more occurrences than there actually is in the string");

        result = twoOccurrences("", "ksjdfhsdlkjfhakld");
        if(result == false) System.out.println("Passed: No occurrence of empty string therefore function returns false");
        else System.out.println("Failed: Utils.twoOccurrences() found more occurrences of empty string than there actually is in the string");

        result = twoOccurrences("a", "");
        if(result == false) System.out.println("Passed: No occurrence of string in an empty string therefore function returns false");
        else System.out.println("Failed: Utils.twoOccurrences() found more occurrences of string than there actually is in the empty string");

        result = twoOccurrences("", "");
        if(result == false) System.out.println("Passed: Only one occurrence of empty string in an empty string therefore function returns false");
        else System.out.println("Failed: Utils.twoOccurrences() found more occurrences of empty string than there actually is in the empty string");

        result = twoOccurrences("a", "bbbbbbbbbbbbbbbb");
        if(result == false) System.out.println("Passed: No occurrence of a string correctly identified as false");
        else System.out.println("Failed: Utils.twoOccurrences() found two occurrences of \"a\" in a string of only \"b\"s");

        System.out.println();

        String remainder = lastPart("an", "banana");
        if(remainder.equals("ana")) System.out.println("Passed: Remainder of banana string correctly returned: " + remainder);
        else System.out.println("Failed: Utils.lastPart() failed to identify correctly the banana remainder: " + remainder);

        //lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word
        remainder = lastPart("zoo", "forest");
        if(remainder.equals("forest")) System.out.println("Passed: Remainder of string correctly returned: " + remainder);
        else System.out.println("Failed: Utils.lastPart() failed to identify correctly the whole stringB as remainder: " + remainder);

        remainder = lastPart("oko", "Maroko");
        if(remainder.equals("")) System.out.println("Passed: Remainder of string correctly returned as empty");
        else System.out.println("Failed: Utils.lastPart() failed to identify empty remainder, remainder: " + remainder);

        remainder = lastPart("www.lksdjf.lala", "ksjdfhwww.lksdjf.lalalfskdjfwww.lksdjf.lala");
        if(remainder.equals("lfskdjfwww.lksdjf.lala")) System.out.println("Passed: Remainder of string correctly returned: " + remainder);
        else System.out.println("Failed: Utils.lastPart() failed to identify the first out of two occurences of stringA, remainder: " + remainder);

        System.out.println();

        int howMany = howMany("GAA", "ATGAACGAATTGAATC");
        if(howMany == 3) System.out.println("Passed: Function correctly counted string occurrences");
        else System.out.println("Failed: Utils.howMany() failed to count correctly GAA string occurrences");

        howMany = howMany("AA", "ATAAAA");
        if(howMany == 2) System.out.println("Passed: Function correctly counted string occurrences");
        else System.out.println("Failed: Utils.howMany() failed to count correctly AA string occurrences");

        howMany = howMany("", "TAATAA");
        if(howMany == 0) System.out.println("Passed: No occurrences of empty string in a string");
        else System.out.println("Failed: Utils.howMany() found empty string in a string");

        howMany = howMany("A", "");
        if(howMany == 0) System.out.println("Passed: There will be no occurrences of any string in an empty string");
        else System.out.println("Failed: Utils.howMany() found some string occurrences in an empty string");

        System.out.println();

        double cgRatio = cgRatio("ATGCCATAG");
        if(cgRatio == (float)4/ (float)9) System.out.println("Passed: cgRatio correctly calculated for the first string, cgRatio: " + cgRatio);
        else System.out.println("Failed: Utils.cgRatio() miscalculated cgRatio: " + cgRatio + ", instead of " + (float)4/ (float)9);

        System.out.println();

        int ctgCount = countCTG("CTGCTGCTGTAA");
        if(ctgCount == 3) System.out.println("Passed: function correctly counted number of CTG occurrences");
        else System.out.println("Failed: Utils.countCTG() failed to count 3 CTG occurrences");

    }
}
