package GameObjects;
import main.Handler;
import java.awt.*;
public class Player extends GameObject {

    Handler handler;
    public Player(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;

    }
    @Override
    public void tick() {

        // movement
        if (handler.isUp()) {
            y -= 50;
            handler.setUp(false);
        }

        if (handler.isDown()) {
            y += 50;
            handler.setDown(false);
        }

        if (handler.isLeft()) {
            x -= 50;
            handler.setLeft(false);
        }

        if (handler.isRight()){
            x += 50;
            handler.setRight(false);
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,48);
    }
}
