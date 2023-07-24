package org.coursera.duke.java.week2;

public class StringsFirstAssignmentsPart3 {
    public static boolean twoOccurrences(String stringA, String stringB) {
        boolean result = false;
        int firstOccurrenceIndex = stringB.indexOf(stringA);
        if(!(firstOccurrenceIndex == -1)) {
            if (!(stringB.indexOf(stringA, firstOccurrenceIndex + stringA.length()) == -1)) {
                result = true;
            }
        }
        return result;
    }

    public static String lastPart(String stringA, String stringB) {
        int firstOccurrence = stringB.indexOf(stringA);
        if (firstOccurrence == -1) return stringB;
        return stringB.substring(firstOccurrence + stringA.length());
    }

    public static void testTwoOccurrences() {
        boolean result = twoOccurrences("by", "A story by Abby Long");
        System.out.println("Result expected to be true, and is: " + result);

        result = twoOccurrences("a", "banana");
        System.out.println("Result expected to be true, and is: " + result);

        result = twoOccurrences("atg", "ctgtatgta");
        System.out.println("Result expected to be false, and is: " + result);
    }

    public static void testLastPart() {
        String result = lastPart("an", "banana");
        System.out.println("Result expected to be 'ana', and is: " + result);

        result = lastPart("zoo", "forest");
        System.out.println("Result expected to be 'forest', and is: " + result);
    }

    public static void main(String[] args) {
        testTwoOccurrences();
        testLastPart();
    }
}
