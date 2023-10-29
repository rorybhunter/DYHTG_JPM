package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    private JButton quitButton;
    Game game;
    public Window(int width, int height, String title, Game game){
        this.game=game;
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        frame.setLocationRelativeTo(null); // centre of screen
        frame.setVisible(true);

        JButton quitButton = new JButton("Give Up :(");
        quitButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==quitButton){
            game.exit();
        }
    }
}
