package GameObjects;

import main.Game;
import main.Handler;

import Challanges.CyperChallange;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public GameObject checkForEncounters() {
        GameObject obj = handler.getObjectAtLocation(x, y);
        return obj;
    }

    public void handleChestEnounter() {
        int i = 0;
    }

    private void handleGooEncounter() {
        JOptionPane.showMessageDialog(null, "You are stuck in GOO!!", "EWW GOO", JOptionPane.WARNING_MESSAGE);
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
                handleChestEnounter();
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
