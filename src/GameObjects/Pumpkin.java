package GameObjects;

import java.awt.*;

public class Pumpkin extends GameObject{
    public Pumpkin(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(250, 106, 2));
        g.fillOval(x,y,50,50);

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
