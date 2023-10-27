import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    public Game(){
        new Window(1000,550, "Spooky Puzzle Game", this);
        this.start();
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

    // updates game. 60 times per sec
    public void tick(){

    }
    // renders game. 1000s times per sec
    public void render(){

        // Creates a buffer of frames so there are a few frames ready to go.
        // when one is created there are 2 more ready to go before it.
        BufferStrategy bs = this.getBufferStrategy();
        if (bs==null){
            this.createBufferStrategy(3); // 3 frames buffer.
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ////////// everything between comments will be drawn

        g.setColor(Color.red);
        g.fillRect(0,0,1000,550);

        /////////
        g.dispose();
        bs.show();
    }
    public static void main(String[] args) {
        new Game();
    }
}
