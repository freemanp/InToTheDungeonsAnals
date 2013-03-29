package dk.cphbusiness.gameViews;

import java.util.concurrent.ArrayBlockingQueue;

import com.google.common.base.Preconditions;

public class GameView {
    ArrayBlockingQueue<String> messageQueue;

    public ArrayBlockingQueue<String> getMessageQueue() {
        return messageQueue;
    }

    public GameView(ArrayBlockingQueue<String> messageQueue) {
        setMessageQueue(messageQueue);
    }

    public void setMessageQueue(ArrayBlockingQueue<String> messageQueue) {
        Preconditions.checkNotNull(messageQueue, "Message queue may not be null");
        
        this.messageQueue = messageQueue;
    }
}
