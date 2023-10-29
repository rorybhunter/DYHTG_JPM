package GameObjects;

import InventoryObjects.InventoryObject;
import main.Game;
import main.Handler;
import Challanges.CyperChallange;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Player extends GameObject {

    Handler handler;
    ArrayList<InventoryObject> inventory = new ArrayList<InventoryObject>();
    Image playerImage;
    Image[] playerImageUp = new Image[2];
    Image[] playerImageDown = new Image[2];
    Image[] playerImageLeft = new Image[2];
    Image[] playerImageRight = new Image[2];
    int score = 0;
    Game game;

    public Player(int x, int y, ID id, Handler handler, Game game) {
        super(x, y, id);
        this.handler = handler;
        playerImage=getPlayerImage();
        this.game=game;
    }

    private Image getPlayerImage(){
        if (playerImage==null){ // got to get the images
        try {
                playerImageUp[0] = ImageIO.read(new File("src/images/boy_up_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageUp[1] = ImageIO.read(new File("src/images/boy_up_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageDown[0] = ImageIO.read(new File("src/images/boy_down_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageDown[1] = ImageIO.read(new File("src/images/boy_down_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageRight[0] = ImageIO.read(new File("src/images/boy_right_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageRight[1] = ImageIO.read(new File("src/images/boy_right_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageLeft[0] = ImageIO.read(new File("src/images/boy_left_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                playerImageLeft[1] = ImageIO.read(new File("src/images/boy_left_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            playerImage = playerImageRight[0];
        }
        return playerImage;
    }
    public GameObject checkForEncounters() {
        GameObject obj = handler.getObjectAtLocation(x, y);
        return obj;
    }

    public void handleChestEnounter(GameObject encounter) {
        Chest chest = (Chest) encounter;
        if (!chest.isOpened()) {
            //run challenge
            // if challenge complete
            chest.setOpened(true);
            addToInventory(chest.contents);
            score+=1;
            JOptionPane.showMessageDialog(null, "You acquired a Golden Pumpkin!", "Congratulations!", JOptionPane.WARNING_MESSAGE);

        }
    }

        private void handleGooEncounter(){
        boolean released = false;
        while (!released){
            JOptionPane.showMessageDialog(null, "You are stuck in GOO!!\n Try and wiggle to get out", "EWW GOO", JOptionPane.WARNING_MESSAGE);
            int change = ThreadLocalRandom.current().nextInt(1,10);
            if (change % 3 == 0){
                released = true;
            }

        }
    }

    private void handleExitEncounter() {
        if (score <=1){
            JOptionPane.showMessageDialog(null, "You do NOT have enough points to open the exit\nYou can gain points by opening chests", "Not enough points", JOptionPane.WARNING_MESSAGE);
        } else{
        game.exit();
        }
    }

    private void handlePumkinEncounter() {
        CyperChallange challange = new CyperChallange();
        boolean result = challange.run();
        if (!result) {
            challange.exit();
            game.exit();
        } else {
            challange.exit();
        }
    }

    public void addToInventory(InventoryObject inventoryObject){
        inventory.add(inventoryObject);
    }
    public void removeFromInventory(InventoryObject inventoryObject){
        inventory.remove(inventoryObject);
    }
    @Override
    public void tick() {
        GameObject encounter = null;
        // movement
        if (handler.isUp()) {
            GameObject obj = handler.getObjectAtLocation(x, y - 50);

            // animate player movement
            if (playerImage==playerImageUp[0]){
                playerImage=playerImageUp[1];
            } else if (playerImage==playerImageUp[1]) {
                playerImage=playerImageUp[0];
            }else {
                playerImage=playerImageUp[0];
            }



            if (obj == null || obj.id != ID.Hedge) {
                y -= 50;
            }
            handler.setUp(false);
            encounter = checkForEncounters();
        }

        if (handler.isDown()) {
            GameObject obj = handler.getObjectAtLocation(x, y + 50);

            // animate player movement
            if (playerImage==playerImageDown[0]){
                playerImage=playerImageDown[1];
            } else if (playerImage==playerImageDown[1]) {
                playerImage=playerImageDown[0];
            }else {
                playerImage=playerImageDown[0];
            }


            if (obj == null || obj.id != ID.Hedge) {
                y += 50;
            }
            handler.setDown(false);
            encounter = checkForEncounters();
        }

        if (handler.isLeft()) {
            GameObject obj = handler.getObjectAtLocation(x - 50, y);


            // animate player movement
            if (playerImage==playerImageLeft[0]){
                playerImage=playerImageLeft[1];
            } else if (playerImage==playerImageLeft[1]) {
                playerImage=playerImageLeft[0];
            }else {
                playerImage=playerImageLeft[0];
            }

            if (obj == null || obj.id != ID.Hedge) {
                x -= 50;
            }
            handler.setLeft(false);
            encounter = checkForEncounters();
        }

        if (handler.isRight()) {
            GameObject obj = handler.getObjectAtLocation(x + 50, y);

            // animate player movement
            if (playerImage==playerImageRight[0]){
                playerImage=playerImageRight[1];
            } else if (playerImage==playerImageRight[1]) {
                playerImage=playerImageRight[0];
            }else {
                playerImage=playerImageRight[0];
            }

            if (obj == null || obj.id != ID.Hedge) {
                x += 50;
            }
            handler.setRight(false);
            encounter = checkForEncounters();
        }
        if (encounter != null) {
            if (encounter.id == ID.Chest) {
                handleChestEnounter(encounter);
            } else if (encounter.id == ID.Exit) {
                handleExitEncounter();
            } else if (encounter.id == ID.Goo) {
                handleGooEncounter();
            } else if (encounter.id == ID.Pumpkin) {
                handlePumkinEncounter();
            }
        }
    }

    @Override
    public void render(Graphics g) {

        if (playerImage != null) {
            g.drawImage(playerImage, x, y, null);
        }else{
            g.setColor(Color.blue);
            g.fillRect(x,y,50,50);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
}
