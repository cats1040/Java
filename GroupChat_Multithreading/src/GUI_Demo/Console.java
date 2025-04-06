// https://www.youtube.com/watch?v=CyVVaBnjvig

// package GUI_Demo;

import java.awt.*;
import javax.swing.*;

public class Console {

    static final JFrame frame = new JFrame("Server console");
    static final JPanel panel = new JPanel();

    public static final JTextArea textArea = new JTextArea();
    public static final JScrollPane scrollPane = new JScrollPane(textArea);

    static final int WIDTH = 640;
    static final int HEIGHT = 700;

    public Console() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scrollPane.setPreferredSize(new Dimension(WIDTH - 32, HEIGHT - 64));
        textArea.setEditable(false);

        panel.add(scrollPane);

        frame.add(panel);
    }

    // public void writeToConsole(String text) {
    // textArea.append(text + "\n");
    // }
}