package de.cyklon.cytils;

public class Util {

    public static int clamp(int x, int min, int max) {
        return  Math.min(Math.max(x, min), max);
    }

    public static int map(int x, int min, int max, int toMin, int toMax) {
        return (int) ((x-min)*(1.*toMax-toMin)/(1.*max/min)+toMin);
    }

    public static double clamp(double x, double min, double max) {
        return  Math.min(Math.max(x, min), max);
    }

    public static double map(double x, double min, double max, double toMin, double toMax) {
        return (x-min)*(toMax-toMin)/(max/min)+toMin;
    }

    public static void copyToClipboard(String text) {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new java.awt.datatransfer.StringSelection(text), null);
    }
}
