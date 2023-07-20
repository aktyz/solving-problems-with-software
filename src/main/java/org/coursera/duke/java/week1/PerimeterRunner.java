package org.coursera.duke.java.week1;

import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        //Start with totalPerim = 0
        double totalPerim = 0;
        //Start with prevPt = the last point
        Point prevPt = s.getLastPoint();
        //For each point currPT in the shape,
        for(Point p : s.getPoints()) {
            //Find distance from prevPt pt to currentPt pt
            double currDist = prevPt.distance(p);
            //Update totalPerim to be totalPerim + distance
            totalPerim += currDist;
            //Update prevPt to be currPt
            prevPt = p;
        }
        //totalPerim is my answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("Perimeter = " + length);
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
