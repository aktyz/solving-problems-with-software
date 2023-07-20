package org.coursera.duke.java.week1;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double distance(Point otherPt) {
        int dx = x - otherPt.getX();
        int dy = y - otherPt.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
