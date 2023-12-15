package org.coursera.duke.java.week4;

import edu.duke.ImageResource;
import edu.duke.Pixel;

public class InvertImageConverter {

    private static final int RGBMax = 255;

    public static ImageResource invertImage(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for(Pixel outPixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(outPixel.getX(), outPixel.getY());

            outPixel.setRed(RGBMax - inPixel.getRed());
            outPixel.setGreen(RGBMax - inPixel.getGreen());
            outPixel.setBlue(RGBMax - inPixel.getBlue());
        }
        return outImage;
    }
}
