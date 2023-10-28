package GameObjects;

import InventoryObjects.GoldenPumpkin;
import InventoryObjects.InventoryObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// chest will contain items e.g. golden pumpkin. need certain amount of pumkins to leave maze.
public class Chest  extends GameObject{
    private Image chestImage;

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public InventoryObject getContents() {
        return contents;
    }

    public void setContents(InventoryObject contents) {
        this.contents = contents;
    }

    private boolean isOpened = false;
    InventoryObject contents;
    public Chest(int x, int y, ID id) {
        super(x, y, id);
        this.contents = new GoldenPumpkin();
        chestImage= getChestImage();
        isOpened=false;
    }


private Image getChestImage() {
    if (isOpened) {
        try {

            chestImage = ImageIO.read(new File("src/images/open_chest.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        try {
            chestImage = ImageIO.read(new File("src/images/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return chestImage;
}
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        chestImage = getChestImage();
        if (chestImage != null) {
            g.drawImage(chestImage, x, y, null);
        }else{
            g.setColor(Color.yellow);
            g.fillRect(x,y,50,50);
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
