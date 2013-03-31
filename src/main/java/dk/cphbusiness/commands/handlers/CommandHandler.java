package dk.cphbusiness.commands.handlers;

import java.util.concurrent.ArrayBlockingQueue;

import com.google.common.base.Preconditions;

import dk.cphbusiness.GameRunner;
import dk.cphbusiness.commands.Command;
import dk.cphbusiness.commands.Commands;

public abstract class CommandHandler {
    
    ArrayBlockingQueue<String> messageQueue;
    ArrayBlockingQueue<Command> commandQueue;
    GameRunner gameRunner;
    Commands commands;
    
    public CommandHandler() {
    }
    
    public void setGameRunner(GameRunner gameRunner) {
        Preconditions.checkNotNull(gameRunner,
                "GameRunner may not be null");

        this.gameRunner = gameRunner;
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
    
    public abstract void handleCommand();

    public void setCommands(Commands commands) {
        Preconditions.checkNotNull(commands,
                "Commands may not be null");
        
        this.commands = commands;
    }
}
