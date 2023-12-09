package org.coursera.duke.java.week4;

import edu.duke.ImageResource;

import static org.coursera.duke.java.week4.GrayScaleConverter.makeGray;

public class GrayScaleConverterTest {
    public static void testMakeGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
}
