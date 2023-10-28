package GameObjects;

import InventoryObjects.InventoryObject;
import main.Game;
import main.Handler;

import Challanges.CyperChallange;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class Player extends GameObject {

    Handler handler;
    ArrayList<InventoryObject> inventory = new ArrayList<InventoryObject>();


    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public GameObject checkForEncounters() {
        GameObject obj = handler.getObjectAtLocation(x, y);
        return obj;
    }

    public void handleChestEnounter(GameObject encounter) {
        Chest chest = (Chest) encounter;
        if (!chest.isOpened()){
            //run challenge
            // if challenge complete
            chest.setOpened(true);
            addToInventory(chest.contents);
        }
    }

    private void handleGooEncounter() {

    }

    private void handleExitEncounter() {
        Game.exit();
    }

    private void handlePumkinEncounter() {
        CyperChallange challange = new CyperChallange();
        boolean result = challange.run();
        if (!result) {
            System.out.println("FAIL");
            challange.exit();
            Game.exit();
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
            if (obj == null || obj.id != ID.Hedge) {
                y -= 50;
            }
            handler.setUp(false);
            encounter = checkForEncounters();
        }

        if (handler.isDown()) {
            GameObject obj = handler.getObjectAtLocation(x, y + 50);
            if (obj == null || obj.id != ID.Hedge) {
                y += 50;
            }
            handler.setDown(false);
            encounter = checkForEncounters();
        }

        if (handler.isLeft()) {
            GameObject obj = handler.getObjectAtLocation(x - 50, y);
            if (obj == null || obj.id != ID.Hedge) {
                x -= 50;
            }
            handler.setLeft(false);
            encounter = checkForEncounters();
        }

        if (handler.isRight()) {
            GameObject obj = handler.getObjectAtLocation(x + 50, y);
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
        g.setColor(Color.blue);
        g.fillRect(x, y, 50, 50);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
}
