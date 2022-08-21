package com.github.cyklon73.cytils.utils;

import java.text.DecimalFormat;

public class Util {

    public static <T> T nonNullOrDefault(T obj, T def) {
        if (obj == null)
            return def;
        return obj;
    }

    public static <T> boolean arrayContains(T[] list, T item) {
        boolean b = false;
        for (T t : list) {
            if (t.equals(item)) {
                b = true;
                break;
            }
        }
        return b;
    }

    public static void runForChar(String message, LetterComp comp) {
        for (int i = 0; i < message.length(); i++) {
            comp.run(message.charAt(i));
        }
    }

    public static String removeSpaces(String message) {
        final String[] msg = {""};
        runForChar(message, new LetterComp() {
            @Override
            public void run(char character) {
                if (character != ' ') msg[0] += character;
            }
        });
        return msg[0];
    }

    public static int clamp(int x, int min, int max) {
        return  java.lang.Math.min(java.lang.Math.max(x, min), max);
    }

    public static int map(int x, int min, int max, int toMin, int toMax) {
        return (int) ((x-min)*(1.*toMax-toMin)/(1.*max/min)+toMin);
    }

    public static double clamp(double x, double min, double max) {
        return  java.lang.Math.min(java.lang.Math.max(x, min), max);
    }

    public static double map(double x, double min, double max, double toMin, double toMax) {
        return (x-min)*(toMax-toMin)/(max/min)+toMin;
    }

    public static void copyToClipboard(String text) {
        java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new java.awt.datatransfer.StringSelection(text), null);
    }

    public static class FILESIZE {
        public static final double
                KILO = 1000L,
                KIBI = 1024L,
                MEGA = KILO * KILO,
                MEBI = KIBI * KIBI,
                GIGA = MEGA * KILO,
                GIBI = MEBI * KIBI,
                TERA = GIGA * KILO,
                TEBI = GIBI * KIBI,
                PETA = TERA * KILO,
                PEBI = TEBI * KIBI,
                EXA = PETA * KILO,
                EXBI = PEBI * KIBI;

        private static final DecimalFormat df = new DecimalFormat("#.##");

        public static String binaryBased(long size) {
            if (size < 0) {
                throw new IllegalArgumentException("Argument cannot be negative");
            } else if (size < KIBI) {
                return df.format(size).concat("B");
            } else if (size < MEBI) {
                return df.format(size / KIBI).concat("KiB");
            } else if (size < GIBI) {
                return df.format(size / MEBI).concat("MiB");
            } else if (size < TEBI) {
                return df.format(size / GIBI).concat("GiB");
            } else if (size < PEBI) {
                return df.format(size / TEBI).concat("TiB");
            } else if (size < EXBI) {
                return df.format(size / PEBI).concat("PiB");
            } else {
                return df.format(size / EXBI).concat("EiB");
            }
        }

        public static String decimalBased(long size) {
            if (size < 0) {
                throw new IllegalArgumentException("Argument cannot be negative");
            } else if (size < KILO) {
                return df.format(size).concat(" B");
            } else if (size < MEGA) {
                return df.format(size / KILO).concat(" KB");
            } else if (size < GIGA) {
                return df.format(size / MEGA).concat(" MB");
            } else if (size < TERA) {
                return df.format(size / GIGA).concat(" GB");
            } else if (size < PETA) {
                return df.format(size / TERA).concat(" TB");
            } else if (size < EXA) {
                return df.format(size / PETA).concat(" PB");
            } else {
                return df.format(size / EXA).concat(" EB");
            }
        }
    }
}
