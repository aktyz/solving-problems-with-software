package org.coursera.duke.java.week2;

import edu.duke.URLResource;

public class StringsFirstAssignmentsPart4 {
    public static void readURLResourceWordByWord (String url) {
        URLResource urlResource = new URLResource(url);
        int youTubeStart;
        for(String s : urlResource.lines()) {
            youTubeStart = s.toLowerCase().indexOf("youtube.com");
            if(!(youTubeStart == -1)) {
                int startIndex = s.toLowerCase().lastIndexOf("\"", youTubeStart);
                int stopIndex = s.toLowerCase().indexOf("\"", startIndex + 1);
                System.out.println(s.substring(startIndex + 1, stopIndex));
            }
        }
    }

    public static void testReadURLResourceWordByWord() {
        readURLResourceWordByWord("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    }

    public static void main(String[] args) {
        testReadURLResourceWordByWord();
    }
}
