package Challanges;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public class JigSaw extends JFrame implements ActionListener{
    JButton[] image_buttons = new JButton[10];
    Map<Integer, Integer[]> connectionsMap = new HashMap<Integer, Integer[]>();
    JLabel instruction_label;
    Integer[] used_numbers = new Integer[9];
    
    public JigSaw(){
        // Window Settings
        setSize(500, 500);
        setLayout(null);
        setVisible(true);

        // Value for the rows and collumns of the buttons
        int edge1 = 55;
        int edge2 = 185;
        int edge3 = 315;
        // Buttons will be sqaure 130 x 130
        int box_size = 130;
        

        Container contentPane = this.getContentPane();
        instruction_label = new JLabel("PLAY");
        contentPane.add(instruction_label);

        //Buttons - create, add to window 
        for (int i = 0; i < 9; i++){
            image_buttons[i] = new JButton(String.valueOf(i));
            add(image_buttons[i]);
            image_buttons[i].addActionListener(this);
        }
        image_buttons[8] = new JButton(" ");
        add(image_buttons[8]);
        image_buttons[8].addActionListener(this);


        // Set button boundaries
        image_buttons[0].setBounds(edge1, edge1, box_size, box_size);
        image_buttons[1].setBounds(edge2, edge1, box_size, box_size);
        image_buttons[2].setBounds(edge3, edge1, box_size, box_size);
        image_buttons[3].setBounds(edge1, edge2, box_size, box_size);
        image_buttons[4].setBounds(edge2, edge2, box_size, box_size);
        image_buttons[5].setBounds(edge3, edge2, box_size, box_size);
        image_buttons[6].setBounds(edge1, edge3, box_size, box_size);
        image_buttons[7].setBounds(edge2, edge3, box_size, box_size);
        image_buttons[8].setBounds(edge3, edge3, box_size, box_size);
        instruction_label.setBounds(edge2, 5, 130,20);

        // Set button connections
        connectionsMap.put(0, new Integer[] {1,3});
        connectionsMap.put(1, new Integer[] {0,4,2});
        connectionsMap.put(2, new Integer[] {1,5});
        connectionsMap.put(3, new Integer[] {0,4,6});
        connectionsMap.put(4, new Integer[] {1,3,5,7});
        connectionsMap.put(5, new Integer[] {2,4,8});
        connectionsMap.put(6, new Integer[] {3,7});
        connectionsMap.put(7, new Integer[] {6,4,8});
        connectionsMap.put(8, new Integer[] {7,5});

        shuffle();
        
    }

    public void buttonPressed(ActionEvent e){
        //get the button image/text
        //if the button has a adjacent blank button, swap their icon and text?
        for (int i = 0; i <9; i++){
            if (e.getSource() == image_buttons[i]){
                String s = image_buttons[i].getText();
                for (int j : connectionsMap.get(i)){
                    // check this
                    if (image_buttons[j].getText().equals(" ")){
                        image_buttons[j].setText(s);
                        image_buttons[i].setText(" ");
                    }
                }
            }
        }
        if (checkWin()){
            System.out.println("a");
            gameWon();
        }
    }

    public void shuffle(){
        image_buttons[0].setText("7");
        image_buttons[1].setText("3");
        image_buttons[2].setText("6");
        image_buttons[3].setText("2");
        image_buttons[4].setText("4");
        image_buttons[5].setText("5");
        image_buttons[6].setText(" ");
        image_buttons[7].setText("1");
        image_buttons[8].setText("0");

            
    }



    public boolean checkWin(){
        boolean win = true;
        for (int i = 0; i< 8; i++){
            String s = image_buttons[i].getText();
            if (!s.equals( String.valueOf(i))){
                win = false;
            }
        }
        String s = image_buttons[8].getText();
        if (!s.equals(" ")){
            win = false;
        }
        return win;
    }

    public void gameWon(){
        dispose();   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonPressed(e);
    }

}