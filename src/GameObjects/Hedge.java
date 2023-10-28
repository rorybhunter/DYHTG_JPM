package GameObjects;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hedge extends GameObject{
    private Image hedgeImage;
    private int width, height;

    public Hedge(int x, int y, ID id){
        super(x,y,id);
        hedgeImage = getHedgeImage();

    }
    private Image getHedgeImage(){
        if (hedgeImage!=null){
            return hedgeImage;
        }else {
            try {
                hedgeImage = ImageIO.read(new File("src/images/bush.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hedgeImage;
    }

    @Override
    public void tick() {

    }
@Override
    public void render(Graphics g) {

    if (hedgeImage != null) {
        g.drawImage(hedgeImage, x, y, null);
    }else{
        g.setColor(new Color(40, 166, 51));
        g.fillRect(x,y,50,50);
    }
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, width, height);
    }
}
