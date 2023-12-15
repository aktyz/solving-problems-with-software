package org.coursera.duke.java.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

import static org.coursera.duke.java.week4.InvertImageConverter.invertImage;

public class BatchInversions {
    public static ImageResource makeInversion(ImageResource inImage) {
        return invertImage(inImage);
    }

    public static void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();

        for(File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            inImage.draw();
            ImageResource invertedImage = makeInversion(inImage);
            String fName = inImage.getFileName();
            String newName = "inverted-" + fName;
            invertedImage.setFileName(newName);
            invertedImage.save();
        }
    }
}
