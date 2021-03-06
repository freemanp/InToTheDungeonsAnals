package dk.cphbusiness.gameViews;

import java.util.concurrent.ArrayBlockingQueue;

import com.google.common.base.Preconditions;

import dk.cphbusiness.commands.Command;
import dk.cphbusiness.commands.Commands;

public abstract class GameView implements Runnable {
    ArrayBlockingQueue<String> messageQueue;
    ArrayBlockingQueue<Command> commandQueue;
    
    public GameView(ArrayBlockingQueue<String> messageQueue,
            ArrayBlockingQueue<Command> commandQueue) {
        setMessageQueue(messageQueue);
        setCommandQueue(commandQueue);
    }
    
    public void setMessageQueue(ArrayBlockingQueue<String> messageQueue) {
        Preconditions.checkNotNull(messageQueue,
                "Message queue may not be null");

        this.messageQueue = messageQueue;
    }

    public void setCommandQueue(ArrayBlockingQueue<Command> commandQueue) {
        Preconditions.checkNotNull(commandQueue,
                "command queue may not be null");

        this.commandQueue = commandQueue;
    }
}
