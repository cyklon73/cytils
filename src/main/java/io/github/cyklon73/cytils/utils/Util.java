package io.github.cyklon73.cytils.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Util {


    public static Integer[] splitInt(int sum, int max) {
        ListArray<Integer> array = new ListArray<>();
        while (sum > 0) {
            if (sum >= max) {
                array.add(max);
                sum -= max;
            } else {
                array.add(sum);
                break;
            }
        }
        return array.toArray(new Integer[array.getSize()]);
    }

    public static String[] splitStringInLines(String s, int max) {
        String[] lines = s.split("\n");
        ListArray<String> result = new ListArray<>();
        String[] currPart = {null, null, null};
        int currInt = 0;
        for (String line : lines) {
            currPart[currInt] = line;
            currInt++;
            if (currInt == 3) {
                currInt = 0;
                f1(result, currPart);
                Arrays.fill(currPart, null);
            }
        }
        f1(result, currPart);
        return result.toArray(new String[result.getSize()]);
    }

    private static void f1(ListArray<String> result, String[] currPart) {
        StringBuilder s1 = new StringBuilder();
        for (int i2 = 0; i2 < currPart.length; i2++) {
            if (currPart[i2] != null) {
                s1.append(currPart[i2]);
                if (i2 != currPart.length-1) s1.append("\n");
            }
        }
        result.add(s1.toString());
    }
    public static File fileFromURL(URL url) {
        return new File(url.getPath().replace("%20", " "));
    }
    public static <T> T[] removeElementFromArray(T[] arr, int index)
    {

        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        T[] anotherArray = (T[]) new Object[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }
    public static void openUrl(String url) {
        try {
            openUrl(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void openUrl(URI url) {
        try {
            Desktop.getDesktop().browse(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean listContains(T[] list, T item) {
        boolean b = false;
        for (T t : list) {
            if (t.equals(item)) {
                b = true;
                break;
            }
        }
        return b;
    }
    public static void waitFor(BooleanExpression expression) {
        waitFor(expression, 50);
    }

    public static void waitFor(BooleanExpression expression, long updateDelay) {
        while (!expression.run()) {
            try {
                Thread.sleep(updateDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static <T> T[] arrayListToArray(ArrayList<T> arrayList) {
        T[] array = (T[]) new Object[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        T[] a;
        return array;
    }
    public static Object[] parseArray(String s) {
        s = removeSpaces(s);

        ArrayList<String> values = new ArrayList<String>();
        String[] currentValue = new String[] {""};
        boolean[] flag = new boolean[] {false, false};
        int[] openArrays = new int[] {0};
        runForChar(s, (c) -> {
            if (c == '[') openArrays[0]++;
            if (c == ']') openArrays[0]--;
            if (openArrays[0] == 1) {
                if (c == ',') {
                    values.add(currentValue[0]);
                    currentValue[0] = "";
                    flag[0] = false;
                } else flag[0] = true;

            } else flag[0] = true;

            if (flag[0]) currentValue[0] += c;
        });
        return values.toArray();
    }
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
