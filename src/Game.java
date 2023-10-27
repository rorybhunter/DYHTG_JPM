import java.awt.*;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    public Game(){
        new Window(1000,550, "Spooky Puzzle Game", this);
    }

    //start thread
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    //stop thread
    private void stop(){
        isRunning= false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    // game loop
    public void run(){

    }
    public static void main(String[] args) {
        new Game();
    }
}
