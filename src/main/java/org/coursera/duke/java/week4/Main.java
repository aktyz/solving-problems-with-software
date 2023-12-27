package org.coursera.duke.java.week4;

import static org.coursera.duke.java.week4.FileData.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Q1:");
//        getNumberOfNamesByGender(FEMALE, new FileResource("resources/week4/us_babynames_by_year/yob1900.csv"));
//        System.out.println("Q2:");
//        getNumberOfNamesByGender(MALE, new FileResource("resources/week4/us_babynames_by_year/yob1905.csv"));
//        System.out.println("Q3:");
//        int emilyRank1960 = getRank(1960,"Emily", "f");
//        System.out.println("Emily ranked " + emilyRank1960 + " as a name in 1960");
//        System.out.println("Q4:");
//        int frankRank1971 = getRank(1971,"Frank", "m");
//        System.out.println("Frank ranked " + frankRank1971 + " as a name in 1971");
//        System.out.println("Q5:");
//        String girl350in1980 = getName(1980, 350, "f");
//        System.out.println("Girl’s name of rank 350 in 1980: " + girl350in1980);
//        System.out.println("Q6:");
//        String boy450in1982 = getName(1982, 450, "m");
//        System.out.println("Boy’s name of rank 450 in 1982: " + boy450in1982);
//        System.out.println();
//        System.out.println("Q7:");
//        whatIsNameInYear("Susan", 1972, 2014, "f");
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Q8:");
//        whatIsNameInYear("Owen", 1974, 2014, "m");
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Q9:");
//        int genevievesHighestRank18802014 = yearOfHighestRank("Genevieve", "f");
//        System.out.println(genevievesHighestRank18802014);
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Q10:");
//        int michsHighestRank18802014 = yearOfHighestRank("Mich", "m");
//        System.out.println(michsHighestRank18802014);
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Q11:");
//        double susansAverageRank = getAverageRank("Susan", "f");
//        System.out.println(susansAverageRank);
//        System.out.println();
//
//        System.out.println();
//        System.out.println("Q12:");
//        double robertsAverageRank = getAverageRank("Robert", "m");
//        System.out.println(robertsAverageRank);
//        System.out.println();

        System.out.println();
        System.out.println("Q13:");
        int rankedHighierThanEmilyIn1990 = getTotalBirthsRankedHigher(1990, "Emily", "f");
        System.out.println(rankedHighierThanEmilyIn1990);
        System.out.println();

        System.out.println();
        System.out.println("Q14:");
        int rankedHighierThanDrewIn1990 = getTotalBirthsRankedHigher(1990, "Drew", "m");
        System.out.println(rankedHighierThanDrewIn1990);
        System.out.println();

    }
}
