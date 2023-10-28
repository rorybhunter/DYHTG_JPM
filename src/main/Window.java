package main;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, Game game){

        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        frame.setLocationRelativeTo(null); // centre of screen
        frame.setVisible(true);

    }
}