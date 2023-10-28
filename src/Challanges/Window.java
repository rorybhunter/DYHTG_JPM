package Challanges;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Window {

    protected JFrame frame = new JFrame("Challange");


    public Window(int width, int height, String title, Challange challange){

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

       // frame.add(challange);
        frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        frame.setLocationRelativeTo(null); // centre of screen

        JTextField input = new JTextField();
        //frame.add(input);

        frame.setVisible(true);
    }

    public void addLabel(String string){
        System.out.println("Helo");
        Label lable = new Label(string);
        lable.setAlignment(Label.CENTER);
        frame.add(lable);
        frame.setVisible(true);

    }

    public void getAnswer(String inputText){

    }
}
