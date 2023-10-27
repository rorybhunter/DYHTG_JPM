import java.awt.*;

public class Game extends Canvas implements Runnable {

    public Game(){
        new Window(1000,550, "Spooky Puzzle Game", this);
    }


    public void run(){}
    public static void main(String[] args) {
        new Game();
    }
}
