import java.awt.*;
import java.util.LinkedList;

public class Handler {
    // used to update all GameObjects
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for (int i = 0; i<object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i<object.size(); i++){
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject temp){
        object.add(temp);
    }
    public void removeObject(GameObject temp){
        object.remove(temp);
    }
}
