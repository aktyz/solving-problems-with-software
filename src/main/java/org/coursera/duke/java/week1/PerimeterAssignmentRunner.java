package org.coursera.duke.java.week1;

import edu.duke.*;
import edu.duke.Point;

import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        edu.duke.Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (edu.duke.Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        /** AP1.1a */
        int numPoints = 0;
        for(Point p : s.getPoints())
            numPoints++;
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        /** AP1.2a */
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        /** AP2.1a */
        double longestSide = 0.0;
        Point lastPoint = s.getLastPoint();
        for(Point p : s.getPoints()) {
            double currDist = p.distance(lastPoint);
            if(currDist > longestSide) {
                longestSide = currDist;
            }
            lastPoint = p;
        }
        return longestSide;
    }

    public double getLargestX(Shape s) {
        /** AP2.2a */
        double largestX = 0.0;
        for(Point p : s.getPoints()) {
            if(p.getX() > largestX)
                largestX = p.getX();
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        /** AP1.1b */
        int numPoints = getNumPoints(s);
        System.out.println("Number of Points = " + numPoints);
        /** AP1.2b */
        double averageLength = getAverageLength(s);
        System.out.println("AverageLength = " + averageLength);
        /** AP2.1b */
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side = " + largestSide);
        /** AP2.2b */
        double largestX = getLargestX(s);
        System.out.println("Largest X point = " + largestX);
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new edu.duke.Point(0,0));
        triangle.addPoint(new edu.duke.Point(6,0));
        triangle.addPoint(new edu.duke.Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}

