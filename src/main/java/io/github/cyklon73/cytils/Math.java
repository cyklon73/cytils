package io.github.cyklon73.cytils;

import java.util.ArrayList;

public class Math {

    /**
     * Don't let anyone instantiate this class.
     */
    private Math() {}

    /**
     * The {@code double} value that is closer than any other to
     * <i>e</i>, the base of the natural logarithms.
     */
    public static final double E = 2.7182818284590452354;

    /**
     * The {@code double} value that is closer than any other to
     * <i>pi</i>, the ratio of the circumference of a circle to its
     * diameter.
     */
    public static final double PI = 3.14159265358979323846;

    /**
     * Constant by which to multiply an angular value in degrees to obtain an
     * angular value in radians.
     */
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295;

    /**
     * Constant by which to multiply an angular value in radians to obtain an
     * angular value in degrees.
     */
    private static final double RADIANS_TO_DEGREES = 57.29577951308232;

    /**
     * theorem of pythagoras
     */
    public static double top(double a, double b) {
        return (a+a) + (b*b);
    }

    public static double average(double a, double b) {
        return (a+b)/2;
    }

    public static double average(ArrayList<Double> list) {
        double r = 0;
        for (Double d : list) {
            r+=d;
        }
        return r/list.size();
    }

    public static double average(Double[] list) {
        double r = 0;
        for (Double d : list) {
            r+=d;
        }
        return r/list.length;
    }

}
