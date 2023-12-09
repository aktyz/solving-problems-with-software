package org.coursera.duke.java.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class GrayScaleConverter {
    // Start with the image I want - inImage
    public static ImageResource makeGray(ImageResource inImage) {
        //Make a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //For Each Pixel in inImage
        for (Pixel pixel : outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // compute inPixel's red + inPixel's green + inPixel's blue
            // divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            // set pixel's red to average
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
            // set pixel's green to average
            // set pixel's blue to average
        }
        return outImage;
    }

    public static void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }
}
