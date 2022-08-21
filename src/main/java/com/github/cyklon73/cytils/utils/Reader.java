package com.github.cyklon73.cytils.utils;

import java.io.File;
import java.io.IOException;

public class Reader {

    private final String content;
    private int line = 0;

    public Reader(File file) throws IOException {
        this.content = FileHelper.readFile(file);
    }

    public String next() {
        line++;
        try {
            String l = getLine(line);
            while (l == null) {
                line++;
                l = getLine(line);
            }
            return l;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String getLine(int line) throws IndexOutOfBoundsException {
        String[] lines = content.split("\n");
        String l = lines[line-1];
        if (Util.removeSpaces(l) == "") return null;
        else return l;
    }



}

