package GameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Goo extends GameObject{
    private Image gooImage;
    public Goo(int x, int y, ID id){
        super(x,y,id);
        gooImage = getGooImage();
    }

    private Image getGooImage(){
        if (gooImage!=null){
            return gooImage;
        }else {
            try {
                gooImage = ImageIO.read(new File("src/images/goo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gooImage;
    }
    @Override
    public void tick() {
    }
@Override
    public void render(Graphics g) {

        if (gooImage != null) {
            g.drawImage(gooImage, x, y, null);
        }else{
            g.setColor(Color.green);
            g.fillRect(x,y,50,50);
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}
