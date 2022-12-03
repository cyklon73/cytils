package io.github.cyklon73.cytils.gui.swing;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class StyleFactory {

    private final SimpleAttributeSet style;

    public StyleFactory() {
        this.style = new SimpleAttributeSet();
    }

    public StyleFactory setSize(int size) {
        StyleConstants.setFontSize(style, size);
        return this;
    }

    public StyleFactory setBackgroundColor(Color color) {
        StyleConstants.setBackground(style, color);
        return this;
    }

    public StyleFactory setForegroundColor(Color color) {
        StyleConstants.setForeground(style, color);
        return this;
    }

    public StyleFactory setFontFamily(String fam) {
        StyleConstants.setFontFamily(style, fam);
        return this;
    }




    public SimpleAttributeSet build() {
        return style;
    }
}
