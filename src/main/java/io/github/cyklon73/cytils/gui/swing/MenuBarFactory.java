package io.github.cyklon73.cytils.gui.swing;

import javax.swing.*;
import java.awt.*;

public class MenuBarFactory {

    private final JMenuBar bar;

    public MenuBarFactory() {
        this(new JMenuBar());
    }

    public MenuBarFactory(JMenuBar bar) {
        this.bar = bar;
    }

    public MenuBarFactory addMenu(JMenu menu) {
        bar.add(menu);
        return this;
    }

    public MenuBarFactory addMenu(String label) {
        bar.add(new JMenu(label));
        return this;
    }

    public MenuBarFactory addPopupMenu(String label) {
        bar.add(new PopupMenu(label));
        return this;
    }

    public MenuBarFactory setUpBar(JFrame frame) {
        frame.setJMenuBar(build());
        return this;
    }

    public JMenuBar build() {
        return this.bar;
    }
}
