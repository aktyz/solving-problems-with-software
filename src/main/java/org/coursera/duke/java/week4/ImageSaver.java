package org.coursera.duke.java.week4;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

public class ImageSaver {
    public static void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String fName = inImage.getFileName();
            String newName = "copy-" + fName;
            inImage.setFileName(newName);
            inImage.save();
        }
    }
}
