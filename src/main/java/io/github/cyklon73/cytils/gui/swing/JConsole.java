package io.github.cyklon73.cytils.gui.swing;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.util.Objects;

public class JConsole extends JTextPane {

    public JConsole() {

    }

    @Override
    public void setBackground(Color bg) {

        if (Objects.equals(this.getContentType(), "text/html")) setText("<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "\t<style>\n" +
                "\t\tp {\n" +
                "\t\t\tcolor: #fcba03;\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</html>");;
        super.setBackground(bg);
    }

    public boolean replace(String regex, String replacement) {
        String currText = this.getText();
        boolean b = currText.contains(regex);
        if (b) System.out.println(replacement);
        this.setText(currText.replace(regex, replacement));
        return b;
    }

    public void printOrReplace(String regex, String replacement) {
        if (!replace(regex, replacement)) log(replacement);
    }

    public void printOrReplace(String regex, String replacement, SimpleAttributeSet attribute) {
        if (!replace(regex, replacement, attribute)) log(replacement, attribute);
    }

    public boolean remove(String regex) {
        return this.replace(regex, "");
    }

    public boolean replace(String regex, String replacement, SimpleAttributeSet attribute) {
        boolean b = this.remove(regex);
        this.log(replacement, attribute);
        return b;
    }
    public void log(String x) {
        log(x, null);
    }

    public void logInLine(String x) {
        logInLine(x, null);
    }

    public void log() {
        log("");
    }


    public void log(String x, SimpleAttributeSet attributes) {
        logInLine(x + "\n", attributes);
    }

    public void logInLine(String x, SimpleAttributeSet attributes) {
        Document doc = this.getDocument();
        try {
            doc.insertString(doc.getLength(), "  " + x, attributes);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        System.out.println(x.substring(0, x.length() -1));
    }


    private Font replaceFontSize(Font font, int size) {
        return new Font(font.getFontName(), font.getStyle(), size);
    }

}
