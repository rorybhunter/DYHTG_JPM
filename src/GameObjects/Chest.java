package GameObjects;

import InventoryObjects.GoldenPumpkin;
import InventoryObjects.InventoryObject;

import java.awt.*;

// chest will contain items e.g. golden pumpkin. need certain amount of pumkins to leave maze.
public class Chest  extends GameObject{

    InventoryObject contents;
    public Chest(int x, int y, ID id) {
        super(x, y, id);
        this.contents = new GoldenPumpkin();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
