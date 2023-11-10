package org.coursera.duke.java.week2.revision;

import edu.duke.URLResource;

public class FindLinks {
    /**
     * This webpage is also saved in Project Resources to switch later the test to hard copy
     * */
    public static final String FIRST_EXAMPLE_URL = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    public static final String YOUTUBE_URL = "youtube.com";

    public static void lookUpLinksOnWebpage(String url, String lookedUpLink) {
        URLResource resource = new URLResource(url);
        int i = 1;
        for(String word : resource.lines()) {
            String processingWord = word.toLowerCase();
            if(processingWord.contains(lookedUpLink)) {
                int lookedUpLinkStartIndex = processingWord.indexOf(lookedUpLink);
                int linkStartIndex = processingWord.lastIndexOf("\"", lookedUpLinkStartIndex) + 1;
                int linkEndIndex = processingWord.indexOf("\"", lookedUpLinkStartIndex + 1);
                System.out.println(i + ": " + word.substring(linkStartIndex, linkEndIndex));
                i++;
            }
        }
    }
}
