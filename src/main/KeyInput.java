package main;

import GameObjects.GameObject;
import GameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++){
            GameObject temp = handler.object.get(i);

            if (temp.getId() == ID.Player){
//                if (key == KeyEvent.VK_W) handler.setUp(true);
//                if (key == KeyEvent.VK_A) handler.setLeft(true);
//                if (key == KeyEvent.VK_S) handler.setDown(true);
//                if (key == KeyEvent.VK_D) handler.setRight(true);
                if (key == KeyEvent.VK_W){
                    handler.setUp(true);
                    handler.setDown(false);
                    handler.setRight(false);
                    handler.setLeft(false);
                }
                if (key == KeyEvent.VK_A) {
                    handler.setUp(false);
                    handler.setDown(false);
                    handler.setRight(false);
                    handler.setLeft(true);
                }
                if (key == KeyEvent.VK_S) {
                    handler.setUp(false);
                    handler.setDown(true);
                    handler.setRight(false);
                    handler.setLeft(false);
                }
                if (key == KeyEvent.VK_D) {
                    handler.setUp(false);
                    handler.setDown(false);
                    handler.setRight(true);
                    handler.setLeft(false);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        for (int i = 0; i < handler.object.size(); i++) {
//            GameObjects.GameObject temp = handler.object.get(i);
//
//            if (temp.getId() == GameObjects.ID.GameObjects.Player) {
//                if (key == KeyEvent.VK_W) handler.setUp(false);
//                if (key == KeyEvent.VK_A) handler.setLeft(false);
//                if (key == KeyEvent.VK_S) handler.setRight(false);
//                if (key == KeyEvent.VK_D) handler.setDown(false);
//            }
//        }
    }
}
