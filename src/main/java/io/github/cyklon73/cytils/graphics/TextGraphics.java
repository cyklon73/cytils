package io.github.cyklon73.cytils.graphics;

import io.github.cyklon73.cytils.utils.Vector2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextGraphics {

    public static void writeOnImage(File outputFile, BufferedImage image, String text, Vector2 vec, Font font, Color color) throws IOException {
        writeOnImage(outputFile, image, text, (int) vec.getX(), (int) vec.getY(), font, color);
    }

    public static void writeOnImage(File outputFile, BufferedImage image, String text, Vector2 vec, int size, Color color) throws IOException {
        writeOnImage(outputFile, image, text, vec, new Font("Arial", Font.BOLD, size), color);
    }

    public static void writeOnImage(File outputFile, BufferedImage image, String text, int x, int y, int size, Color color) throws IOException {
        writeOnImage(outputFile, image, text, x, y, new Font("Arial", Font.BOLD, size), color);
    }

    public static void writeOnImage(File outputFile, BufferedImage image, String text, int x, int y, Font font, Color color) throws IOException {
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(font);
        g2.setColor(color);

        g2.drawString(text, x, y);
        ImageIO.write(image, "png", outputFile);
    }

    public static void textToGraphics(String text, File img_path) {
        String[] text_array = text.split("[\n]");
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Consolas", Font.BOLD, 12);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(getLongestLine(text_array));
        int lines = getLineCount(text);
        int height = fm.getHeight() * (lines + 4);
        g2d.dispose();
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);

        for (int i = 1; i <= lines; ++i) {
            g2d.drawString(text_array[i - 1], 0, fm.getAscent() * i);
        }
        g2d.dispose();
        try {
            ImageIO.write(img, "png", img_path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int getLineCount(String text) {
        return text.split("[\n]").length;
    }

    private static String getLongestLine(String[] arr) {
        String max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max.length() < arr[i].length()) {
                max = arr[i];
            }
        }
        return max;
    }
}
