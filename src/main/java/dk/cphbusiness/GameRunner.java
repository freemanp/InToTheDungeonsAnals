package dk.cphbusiness;

import java.util.concurrent.ArrayBlockingQueue;

import dk.cphbusiness.commands.Command;
import dk.cphbusiness.commands.Commands;
import dk.cphbusiness.commands.handlers.CommandHandler;
import dk.cphbusiness.exceptions.CommandNotRegisteredException;
import dk.cphbusiness.gameViews.CLIView;
import dk.cphbusiness.models.Dungeon;
import dk.cphbusiness.models.Player;

public class GameRunner {
    private final int QUEUE_CAPACITY = 100;
    private ArrayBlockingQueue<String> messageQueue; 
    private ArrayBlockingQueue<Command> commandQueue; 
    
    private boolean isGameRunning;
    
    Thread gameViewThread;
    private Commands commands;
    
    public GameRunner(Commands commands) {
        this.commands = commands;
        this.isGameRunning = false;
        
        messageQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);
        commandQueue = new ArrayBlockingQueue<Command>(QUEUE_CAPACITY);
        
        CLIView cliView = new CLIView(messageQueue, commandQueue);
        gameViewThread = new Thread(cliView);
        gameViewThread.setDaemon(true);
    }

    public void start() {
        isGameRunning = true;
        gameViewThread.start();
        initializeGame();
        
        while(isGameRunning) {
            Command cmd = null;

            try {
                cmd = commandQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Class<? extends CommandHandler> handlerClass = null;
            try {
                handlerClass = commands.getCommandHandler(cmd);
            } catch (CommandNotRegisteredException e) {
                try {
                    messageQueue.put("Command '" + cmd.getName() + "' is not valid. Type help for more assistence.");
                    continue;
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            
            CommandHandler handler = null;
            try {
                handler = handlerClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            
            handler.setMessageQueue(messageQueue);
            handler.setCommandQueue(commandQueue);
            handler.setGameRunner(this);
            handler.setCommands(commands);
            
            handler.handleCommand();
        }
    }
    
    private void initializeGame() {
        Dungeon d1 = new Dungeon();
        Dungeon d2 = new Dungeon();
        
        d1.addConnectedDungeon(d2);
        
        Player player = new Player(d1);
    }

    public void stop() {
        isGameRunning = false;
    }
}
