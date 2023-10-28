package Challanges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class Window {

    protected JFrame frame = new JFrame("Challange");
    protected JPanel panel = (JPanel) frame.getContentPane();
    protected boolean correct;


    public Window(int width, int height, String titl, Challange challangee, Color colour){

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        panel.setBackground(colour);


       // frame.add(challange);
        frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close window
        frame.setLocationRelativeTo(null); // centre of screen


    }

        //JTextField input = new JTextField();
       // frame.add(input);

       // frame.setVisible(true);


    public void addLabel(String string, int x, int y){
        panel.setLayout(null);
        JLabel label = new JLabel(string);
        //label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        //frame.setVisible(true);

    }


    public boolean getAnswer(String inputText, String answer) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        frame.setLayout(new FlowLayout());

        JTextField userInputField = new JTextField(20);
        JButton inputButton = new JButton(inputText);

        frame.add(userInputField);
        frame.add(inputButton);

        // Define an action listener for the button
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the user's input from the JTextField
                String userInput = userInputField.getText();
                if (userInput.equals(answer)) {
                    JOptionPane.showMessageDialog(frame, "Correct!, the pumkin lets you pass this time", "Correct", JOptionPane.INFORMATION_MESSAGE);
                    correct = true;
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong!, the pumkin explodes killing you", "Incorrect", JOptionPane.ERROR_MESSAGE);
                    correct = false;
                }

                latch.countDown(); // Signal that user input is received
            }
        });

        frame.setVisible(true);
        System.out.println("1");
        latch.await(); // Wait until user input is received
        System.out.println("2");
        return correct;
    }

    public void exit() {
        frame.dispose();
    }
}
