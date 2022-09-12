package ui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int width = 1600;
        int height = 900;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.add(new GUI());
        frame.setVisible(true);
    }
}
