package GameObjects;

import java.awt.*;

public class Goo extends GameObject{
    public Goo(int x, int y, ID id){
        super(x,y,id);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(31, 240, 42)); //031240042
        g.fillOval(x, y, 50, 50);
       // g.fillRect(x,y,50,50);

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}
