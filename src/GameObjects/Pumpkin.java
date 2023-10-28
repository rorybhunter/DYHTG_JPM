package GameObjects;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pumpkin extends GameObject{
    private Image pumpkinImage;
    public Pumpkin(int x, int y, ID id){
        super(x,y,id);
        pumpkinImage = getPumkinImage();
    }

        private Image getPumkinImage(){
        if (pumpkinImage!=null){
            return pumpkinImage;
        }else {
            try {
                pumpkinImage = ImageIO.read(new File("src/images/carved_pumkin.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pumpkinImage;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
   
        if (pumpkinImage != null) {
            g.drawImage(pumpkinImage, x, y, null);
        } else {
            g.setColor(new Color(250, 106, 2));
            g.fillOval(x, y, 50, 50);
        }

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
