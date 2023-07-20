package org.coursera.duke.java.week1;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;
import java.io.File;

public class PerimeterAssignmentRunnerCompleted2022 {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
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
        int numPoints = 0;
        for (Point currPt : s.getPoints()) {
            numPoints = numPoints + 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        if (getNumPoints(s) != 0) {
            return getPerimeter(s)/(double) getNumPoints(s);
        } else {
            return 0.0;
        }
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            if(prevPt.distance(currPt) > largestSide) {
                largestSide = prevPt.distance(currPt);
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        Point prevPt = s.getLastPoint();
        double largestX = prevPt.getX();
        for (Point currPt : s.getPoints()) {
            if (currPt.getX() > largestX) {
                largestX = currPt.getX();
            }
            prevPt = currPt;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPerimeter) {
                largestPerimeter = getPerimeter(s);
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        double largestPerim = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double loopPerim = getPerimeter(s);
            if(loopPerim > largestPerim) {
                largestPerim = loopPerim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        System.out.println("file content: ");
        System.out.println(fr.asString());
        Shape s = new Shape(fr);
        System.out.println("perimeter = " + getPerimeter(s));
        System.out.println("number of Points = " + getNumPoints(s));
        System.out.println("average side length = " + getAverageLength(s));
        System.out.println("largest Side = " + getLargestSide(s));
        System.out.println("largest X = " + getLargestX(s));
        System.out.println("");

    }

    public void testPerimeter (FileResource fr) {
        System.out.println("file content: ");
        System.out.println(fr.asString());
        Shape s = new Shape(fr);
        System.out.println("perimeter = " + getPerimeter(s));
    }


    public void testPerimeterMultipleFiles() {
        double perim = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + perim);
    }

    public void testFileWithLargestPerimeter() {
        String largestPerimFileName = getFileWithLargestPerimeter();
        System.out.println("File containing largest perimeter object: " + largestPerimFileName);
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
        PerimeterAssignmentRunnerCompleted2022 pr = new PerimeterAssignmentRunnerCompleted2022();
        pr.testFileWithLargestPerimeter();
    }
}
