package de.cyklon.cytils.edsf;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class EDSF {

    private File file;

    public EDSF(File file) {
        this.file = file;
    }


    public Data decodeReader () {
        try {
            String content = FileUtils.readFile(file);
            ArrayList<String> contentList = new ArrayList<>();
            for (String line:content.split("\n")) {contentList.add(decode(line));}
            String[] contentArray = new String[contentList.size()];
            for (int i = 0; i < contentList.size(); i++) {
                contentArray[i] = contentList.get(i);
            }
            return new Data(contentArray, DataType.DECODED);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Data encodeReader () {
        try {
            String[] s = new String[] {encode(FileUtils.readFile(file))};
            return new Data(s, DataType.ENCODED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void decodeReadWriter () {
        try {
            String s = FileUtils.readFile(file);
            FileUtils.writeFile(decode(s), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeReadWriter () {
        try {
            String s = FileUtils.readFile(file);
            FileUtils.writeFile(encode(s), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decodeWriter (String s) {
        try {
            FileUtils.writeFile(decode(s), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeWriter (String s) {
        try {
            FileUtils.writeFile(encode(s), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeWriter (String[] s) {
        String s1 = "";
        for (String s2: s) {
            s1 += encode(s2) + "\n";
        }
        try {
            FileUtils.writeFile(s1, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeWriter (ArrayList<String> s) {
        String s1 = "";
        for (String s2: s) {
            s1 += encode(s2) + "\n";
        }
        try {
            FileUtils.writeFile(s1, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String decode(String s) {
        if (s == null) {
            return null;
        }
        String out = s;
        for (int i = 0; i < 7; i++) {
            out = BASE64.decode(out);
        }
        return out;
    }

    private String encode(String s) {
        if (s == null) {
            return null;
        }
        String out = s;
        for (int i = 0; i < 7; i++) {
            out = BASE64.encode(out);
        }
        return out;
    }

    private static class BASE64 {

        public static String decode(String input) {
            byte[] decoded = Base64.getDecoder().decode(input.getBytes(StandardCharsets.UTF_8));
            return new String(decoded, StandardCharsets.UTF_8);
        }

        public static String encode(String input) {
            byte[] arg = input.getBytes(StandardCharsets.UTF_8);
            return Base64.getEncoder().encodeToString(arg);
        }
    }

    private static class FileUtils {
        public static String readFile(final File fileIn) throws IOException {

            final FileReader fileReader = new FileReader(fileIn);
            final BufferedReader buffReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();

            String currLine;

            while ((currLine = buffReader.readLine()) != null && !currLine.startsWith("#")) {
                sb.append(currLine + "\n");
            }

            buffReader.close();
            fileReader.close();

            return sb.toString();
        }

        public static void writeFile(String text, File file) throws IOException {
            if (file.exists()) {
                file.delete();
            }
            final PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.println(text);
            writer.close();
        }
    }
}

