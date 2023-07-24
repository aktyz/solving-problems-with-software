package org.coursera.duke.java.week2;

public class StringsSecondAssignmentsPart2 {

    public static int firstImplementationHowMany(String a, String b) {
        int i = 0;
        int count = 0;
        while(true) {
            i = b.indexOf(a, i);
            if(i == -1) break;
            else {
                count++;
                i = i + a.length();
            }
        }
        return count;
    }

    public static int howMany(String a, String b) {
        int count = 0;
        int i = b.indexOf(a);
        while(i != -1 && !a.isEmpty()) {
            count++;
            i = b.indexOf(a, i + a.length());
        }
        return count;
    }

    public static void testHowMany() {
        int result = howMany("GAA", "ATGAACGAATTGAATC");
        /**
         * start looking from the beginning of b
         * find first occurrence at index 2, increment count
         * jump to the end of GAA (2 + GAA.length())
         * start looking from that place
         * find second occurrence at index 6, increment count
         * jump to the end of GAA (6 + GAA.length())
         * start looking from that place
         * find third occurrence at index 11, increment count
         * jump to the end of GAA (11 + GAA.length())
         * start looking from that place - no occurrence found, return count
         */
        if(result != 3) System.out.println("Error in first case!");

        result = howMany("AA", "ATAAAA");
        if(result != 2) System.out.println("Error in second case!");

        result = howMany("xyz", "ffffffffffssssssssssyiz");
        if(result != 0) System.out.println("Error in third case!");

        result = howMany("ab", "");
        if(result != 0) System.out.println("Error in fourth case!");

        result = howMany("", "");
        if(result != 0) System.out.println("Error in fifth case!");

        result = howMany("", "sdklfj");
        if(result != 0) System.out.println("Error in sixth case!");

        System.out.println("testing howMany() completed");
    }
    public static void main(String[] args) {
        // Quiz use case:
        int result = howMany("", "");
        System.out.println("Number of occurrences in your case: " + result);
        testHowMany();
    }
}
