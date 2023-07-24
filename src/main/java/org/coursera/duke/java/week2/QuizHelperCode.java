package org.coursera.duke.java.week2;

public class QuizHelperCode {
    public static void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            //System.out.println("String found on index: " + index);
            String found = input.substring(index+1, index+4);
            System.out.println("String found: " + found);
            index = input.indexOf("abc",index+3);
            //System.out.println("Updated index: " + index);
            System.out.println();
        }
    }

    public static void test(){
        //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
        findAbc("abcabcabcabca");
    }
    public static void main(String[] args) {
        test();
    }
}
