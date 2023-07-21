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
        /** AP3.1 */
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            if(currentPerimeter > largestPerimeter)
                largestPerimeter = currentPerimeter;
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        /** AP3.3 */
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        String largestPerimeterFileName = "";
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPerimeter = getPerimeter(s);
            if(currentPerimeter>largestPerimeter) {
                largestPerimeter = currentPerimeter;
                largestPerimeterFileName = f.getName();
            }
        }
        return largestPerimeterFileName;
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
        /** AP3.2 */
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter across chosen files is " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        /** AP3.4 */
        String fileName = getFileWithLargestPerimeter();
        System.out.println("Name of the file containing largest Perimeter: " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
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
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}

