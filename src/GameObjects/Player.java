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
            if (!handler.isObjectAtLocation(x, y - 50, ID.Hedge)){
                y -= 50;
            }
            handler.setUp(false);
            checkForEncounters();
        }

        if (handler.isDown()) {
            if (!handler.isObjectAtLocation(x, y + 50, ID.Hedge)){
                y += 50;
            }
            handler.setDown(false);
            checkForEncounters();
        }

        if (handler.isLeft()) {
            if (!handler.isObjectAtLocation(x - 50, y, ID.Hedge)){
                x -= 50;
            }
            handler.setLeft(false);
            checkForEncounters();
        }

        if (handler.isRight()){
            if (!handler.isObjectAtLocation(x + 50, y, ID.Hedge)){
                x += 50;
            }
            handler.setRight(false);
            checkForEncounters();
        }
    }

    public void checkForEncounters(){
        for (ID id : ID.values()){
            if(id == ID.Player){
                
            } else if(handler.isObjectAtLocation(x, y, id)){
                System.out.println(id);
            }
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
