package org.coursera.duke.java.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class HelloWorld {
    public static void runHello() {
//        FileResource res = new FileResource("hello_unicode.txt");
//        for(String line : res.lines()) {
//            System.out.println(line);
//        }
        Scanner sc;
        try {
            sc = new Scanner(new File("/resources/hello_unicode.txt"));
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
