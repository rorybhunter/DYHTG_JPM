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
            GameObject obj = handler.getObjectAtLocation(x, y - 50);
            if (obj==null || obj.id != ID.Hedge){
                y -= 50;
            }
            handler.setUp(false);
            checkForEncounters();
        }

        if (handler.isDown()) {
            GameObject obj = handler.getObjectAtLocation(x, y + 50);
            if (obj==null || obj.id != ID.Hedge){
                y+=50;
            }
            handler.setDown(false);
            checkForEncounters();
        }

        if (handler.isLeft()) {
            GameObject obj = handler.getObjectAtLocation(x - 50, y);
            if (obj==null || obj.id != ID.Hedge){
                x-=50;
            }
            handler.setLeft(false);
            checkForEncounters();
        }

        if (handler.isRight()){
            GameObject obj = handler.getObjectAtLocation(x + 50, y);
            if (obj==null || obj.id != ID.Hedge){
                x+=50;
            }
            handler.setRight(false);
            checkForEncounters();
        }
    }

    public GameObject checkForEncounters(){
        GameObject obj = handler.getObjectAtLocation(x,y);
        return obj;
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
