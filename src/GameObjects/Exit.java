package GameObjects;

import java.awt.*;

public class Exit extends GameObject{
    public Exit(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(x,y,50,50);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}
