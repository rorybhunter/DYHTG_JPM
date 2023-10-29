package GameObjects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Exit extends GameObject{
    private Image exitImage;

    public Exit(int x, int y, ID id){
        super(x,y,id);
        exitImage=getExitImage();
    }
    private Image getExitImage(){
        if (exitImage!=null){
            return exitImage;
        }else {
            try {
                exitImage = ImageIO.read(new File("src/images/exit.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exitImage;
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        if (exitImage != null) {
            g.drawImage(exitImage, x, y, null);
        }else{
            g.setColor(Color.BLACK);
            g.fillRect(x,y,50,50);
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}
