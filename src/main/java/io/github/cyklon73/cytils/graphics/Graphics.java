package io.github.cyklon73.cytils.graphics;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graphics {

    public static void mergeFiles(File file, File... files) throws IOException {
        int heightTotal = 0;
        int maxWidth = 100;

        List<BufferedImage> images = new ArrayList<>();

        for (File f : files) {
            BufferedImage image = ImageIO.read(f);
            images.add(image);
        }


        for (BufferedImage bufferedImage : images) {
            heightTotal += bufferedImage.getHeight();
            if (bufferedImage.getWidth() > maxWidth) {
                maxWidth = bufferedImage.getWidth();
            }
        }


        int heightCurr = 0;
        BufferedImage concatImage = new BufferedImage(maxWidth, heightTotal, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = concatImage.createGraphics();
        for (BufferedImage bufferedImage : images) {
            g2d.drawImage(bufferedImage, 0, heightCurr, null);
            heightCurr += bufferedImage.getHeight();
        }

        File compressedImageFile = file;
        OutputStream outputStream = new FileOutputStream(compressedImageFile);

        float imageQuality = 0.7f;
        Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpeg");

        if (!imageWriters.hasNext())
            throw new IllegalStateException("Writers Not Found!!");

        ImageWriter imageWriter = imageWriters.next();
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);

        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

        //Set the compress quality metrics
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(imageQuality);

        //Created image
        imageWriter.write(null, new IIOImage(concatImage, null, null), imageWriteParam);

        // close all streams
        outputStream.close();
        imageOutputStream.close();
        imageWriter.dispose();
    }
}
