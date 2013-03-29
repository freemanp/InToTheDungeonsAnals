package dk.cphbusiness.gameViews;

import java.util.concurrent.ArrayBlockingQueue;

import com.google.common.base.Preconditions;

public abstract class GameView implements Runnable {
    ArrayBlockingQueue<String> messageQueue;
    ArrayBlockingQueue<String> commandQueue;

    public ArrayBlockingQueue<String> getMessageQueue() {
        return messageQueue;
    }

    public GameView(ArrayBlockingQueue<String> messageQueue,
            ArrayBlockingQueue<String> commandQueue) {
        setMessageQueue(messageQueue);
        setCommandQueue(commandQueue);
    }

    public void setMessageQueue(ArrayBlockingQueue<String> messageQueue) {
        Preconditions.checkNotNull(messageQueue,
                "Message queue may not be null");

        this.messageQueue = messageQueue;
    }

    public void setCommandQueue(ArrayBlockingQueue<String> commandQueue) {
        Preconditions.checkNotNull(commandQueue,
                "command queue may not be null");

        this.commandQueue = commandQueue;
    }
}
