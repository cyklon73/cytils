package io.github.cyklon73.cytils.gui;

import java.awt.color.ColorSpace;

public class Color extends java.awt.Color {

    public Color(java.awt.Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue());
    }

    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    public Color(int rgb) {
        super(rgb);
    }

    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    public Color(float r, float g, float b) {
        super(r, g, b);
    }

    public Color(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public Color(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    public String getHex() {
        int rgba = (getRGB() << 8) | getAlpha();
        return String.format("#%08X", rgba);
    }

    public double[] getCMYK() {
        double percentageR = getRed() / 255.0 * 100;
        double percentageG = getGreen() / 255.0 * 100;
        double percentageB = getBlue() / 255.0 * 100;

        double k = 100 - Math.max(Math.max(percentageR, percentageG), percentageB);

        if (k == 100) {
            return new double[]{ 0, 0, 0, 100 };
        }

        double c = ((100 - percentageR - k) / (100 - k) * 100);
        double m = ((100 - percentageG - k) / (100 - k) * 100);
        double y = ((100 - percentageB - k) / (100 - k) * 100);

        return new double[]{ c, m, y, k };
    }

    public double[] getHSV() {
        int r = getRed(), g = getGreen(), b = getBlue();
        double h, s, v;

        int min, max, delta;

        min = Math.min(Math.min(r, g), b);
        max = Math.max(Math.max(r, g), b);

        v = max;

        delta = max - min;

        if (max != 0)
            s = delta / max;
        else {
            s = 0;
            h = -1;
            return new double[] { h, s, v };
        }

        if (r == max)
            h = (g - b) / delta;
        else if (g == max)
            h = 2 + (b - r) / delta;
        else
            h = 4 + (r - g) / delta;

        h *= 60;

        if (h < 0)
            h += 360;

        h = (h * 1.0);
        s = (s * 100.0);
        v = ((v / 256.0) * 100.0);
        return new double[] { h, s, v };
    }

    public double[] getHSL() {
        //  Get RGB values in the range 0 - 1

        float[] rgb = getRGBColorComponents( null );
        double r = rgb[0];
        double g = rgb[1];
        double b = rgb[2];

        //	Minimum and Maximum RGB values are used in the HSL calculations

        double min = Math.min(r, Math.min(g, b));
        double max = Math.max(r, Math.max(g, b));

        //  Calculate the Hue

        double h = 0;

        if (max == min)
            h = 0;
        else if (max == r)
            h = ((60 * (g - b) / (max - min)) + 360) % 360;
        else if (max == g)
            h = (60 * (b - r) / (max - min)) + 120;
        else if (max == b)
            h = (60 * (r - g) / (max - min)) + 240;

        //  Calculate the Luminance

        double l = (max + min) / 2;
        //System.out.println(max + " : " + min + " : " + l);

        //  Calculate the Saturation

        double s = 0;

        if (max == min)
            s = 0;
        else if (l <= .5f)
            s = (max - min) / (max + min);
        else
            s = (max - min) / (2 - max - min);

        return new double[] {h, s * 100, l * 100};
    }
}
