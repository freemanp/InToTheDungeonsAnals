package dk.cphbusiness.gameViews;

import java.util.concurrent.ArrayBlockingQueue;

public class CLIView extends GameView {

    public CLIView(ArrayBlockingQueue<String> messageQueue,
            ArrayBlockingQueue<String> commandQueue) {
        super(messageQueue, commandQueue);
    }

    public void run() {
        while (true) {
            String message;

            try {
                message = messageQueue.take();
            } catch (InterruptedException e) {
                continue;
            }

            System.out.println(message);
        }
    }
}
