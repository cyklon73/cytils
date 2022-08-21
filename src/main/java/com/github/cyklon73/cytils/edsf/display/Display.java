package com.github.cyklon73.cytils.edsf.display;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class Display extends JFrame {

    public JTextArea output = new JTextArea();
    public JCheckBox alphabet = new JCheckBox();
    public JCheckBox capital = new JCheckBox();
    public JButton bcopy = new JButton();

    public boolean b1 = false;
    public boolean b2 = false;
    public boolean b3 = false;
    public boolean b4 = false;
    public boolean b5 = false;
    public boolean b6 = false;
    public boolean b7 = false;

    public Color cS1 = new Color(61, 61, 61);
    public Color cS2 = new Color(61, 61, 61);
    public Color cS3 = new Color(61, 61, 61);
    public Color cS4 = new Color(61, 61, 61);
    public Color cS5 = new Color(61, 61, 61);
    public Color cS6 = new Color(61, 61, 61);
    public Color cS7 = new Color(61, 61, 61);

    public JButton bSegment1 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS1);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    public JButton bSegment2 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS2);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };
    public JButton bSegment3 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS3);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };    public JButton bSegment4 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS4);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };    public JButton bSegment5 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS5);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };    public JButton bSegment6 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS6);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };    public JButton bSegment7 = new JButton(){
        @Override
        public void paint(Graphics g) {
            g.setColor(cS7);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    };

    public Display () {
        super("EDSF-Display");

        int height = 440, width = 200;

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2-width/2, d.height/2-height/2);
        setResizable(false);
        setSize(width, height);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        updateOutput();

        bcopy.setText("copy");
        bcopy.setBounds(50, 280, 100, 20);
        bcopy.addActionListener(e -> {
            Util.copyToClipboard(output.getText());
            showMessageDialog(this, "Bytes in Zwischenablage kopiert!", "Copy", INFORMATION_MESSAGE);
        });
        add(bcopy);

        output.setBounds(50, 300, 100, 20);
        output.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59)));
        output.setEditable(false);
        add(output);

        alphabet.setBounds(50, 320, 150, 20);
        alphabet.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59)));
        alphabet.setText("Buchstabe");
        alphabet.addActionListener(e -> {
            updateOutput();
        });
        add(alphabet);

        capital.setBounds(50, 340, 150, 20);
        capital.setBorder(BorderFactory.createLineBorder(new Color(59, 59, 59)));
        capital.setText("Groß buchstabe");
        capital.addActionListener(e -> {
            updateOutput();
        });
        add(capital);

        bSegment1.setBounds(50, 50, 10, 100);
        bSegment1.addActionListener(e -> {
            if (b1) {
                cS1 = new Color(61, 61, 61);
                bSegment1.repaint();
                b1 = false;
            } else {
                cS1 = new Color(255, 0, 0);
                bSegment1.repaint();
                b1 = true;
            }
            updateOutput();
        });
        add(bSegment1);


        bSegment2.setBounds(50, 160, 10, 100);
        bSegment2.addActionListener(e -> {
            if (b2) {
                cS2 = new Color(61, 61, 61);
                bSegment2.repaint();
                b2 = false;
            } else {
                cS2 = new Color(255, 0, 0);
                bSegment2.repaint();
                b2 = true;
            }
            updateOutput();
        });
        add(bSegment2);

        bSegment3.setBounds(130, 160, 10, 100);
        bSegment3.addActionListener(e -> {
            if (b3) {
                cS3 = new Color(61, 61, 61);
                bSegment3.repaint();
                b3 = false;
            } else {
                cS3 = new Color(255, 0, 0);
                bSegment3.repaint();
                b3 = true;
            }
            updateOutput();
        });
        add(bSegment3);

        bSegment4.setBounds(130, 50, 10, 100);
        bSegment4.addActionListener(e -> {
            if (b4) {
                cS4 = new Color(61, 61, 61);
                bSegment4.repaint();
                b4 = false;
            } else {
                cS4 = new Color(255, 0, 0);
                bSegment4.repaint();
                b4 = true;
            }
            updateOutput();
        });
        add(bSegment4);

        bSegment5.setBounds(60, 40, 70, 10);
        bSegment5.addActionListener(e -> {
            if (b5) {
                cS5 = new Color(61, 61, 61);
                bSegment5.repaint();
                b5 = false;
            } else {
                cS5 = new Color(255, 0, 0);
                bSegment5.repaint();
                b5 = true;
            }
            updateOutput();
        });
        add(bSegment5);

        bSegment6.setBounds(60, 150, 70, 10);
        bSegment6.addActionListener(e -> {
            if (b6) {
                cS6 = new Color(61, 61, 61);
                bSegment6.repaint();
                b6 = false;
            } else {
                cS6 = new Color(255, 0, 0);
                bSegment6.repaint();
                b6 = true;
            }
            updateOutput();
        });
        add(bSegment6);

        bSegment7.setBounds(60, 260, 70, 10);
        bSegment7.addActionListener(e -> {
            if (b7) {
                cS7 = new Color(61, 61, 61);
                bSegment7.repaint();
                b7 = false;
            } else {
                cS7 = new Color(255, 0, 0);
                bSegment7.repaint();
                b7 = true;
            }
            updateOutput();
        });
        add(bSegment7);

        setVisible(true);
    }

    public void updateOutput() {
        String s = "";

        if (b5) s += "1";
        else s += "0";
        if (b4) s += "1";
        else s += "0";
        if (b3) s += "1";
        else s += "0";
        if (b7) s += "1";
        else s += "0";
        if (b2) s += "1";
        else s += "0";
        if (b1) s += "1";
        else s += "0";
        if (b6) s += "1";
        else s += "0";
        if (alphabet.isSelected()) s += "0";
        else s += "1";
        if (capital.isSelected()) s += "1";
        else s += "0";
        output.setText(s);
    }

}
