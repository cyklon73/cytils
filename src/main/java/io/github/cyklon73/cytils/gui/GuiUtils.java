package io.github.cyklon73.cytils.gui;

import javax.swing.*;
import java.awt.*;

public class GuiUtils {

    public static void setScreenToCenter(JFrame frame) {
        Dimension d = getScreenSize();
        int width = frame.getWidth(), height = frame.getHeight();
        frame.setLocation(d.width/2-width/2, d.height/2-height/2);
    }

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
