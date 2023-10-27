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
    // notch game loop
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime(); // time since last iteration (helpful for computing delta)
        double amountOfTicks = 60.0; // max FPS
        double ns = 1_000_000_000 / amountOfTicks; // nanoseconds per frame
        double delta =0; // 'progress' that must be elapsed before next frame
        long timer = System.currentTimeMillis(); // current time, to know when next to display fps
        int frames = 0; // frames displayed since last displayed fps
        while (isRunning){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                // updates++
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
                // updates = 0;
            }
        }
        stop();
    }
    public static void main(String[] args) {
        new Game();
    }
}
