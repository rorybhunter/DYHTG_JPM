package GameObjects;

import java.awt.*;

public class Hedge extends GameObject{
    public Hedge(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {

    }
@Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x,y,50,50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,50,50);
    }
}
