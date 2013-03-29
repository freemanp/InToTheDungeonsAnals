package dk.cphbusiness.gameViews;

import java.util.concurrent.ArrayBlockingQueue;

public class CLIView extends GameView implements Runnable {
    
    public CLIView(ArrayBlockingQueue<String> messageQueue) {
        super(messageQueue);
    }

    public void run() {
    }
}
