package dk.cphbusiness;

import java.util.concurrent.ArrayBlockingQueue;

import dk.cphbusiness.gameViews.CLIView;
import dk.cphbusiness.models.Dungeon;
import dk.cphbusiness.models.Player;

public class GameRunner {
    private final int QUEUE_CAPACITY = 100;
    private ArrayBlockingQueue<String> messageQueue; 
    private ArrayBlockingQueue<String> commandQueue; 
    
    private boolean isGameRunning;
    
    Thread gameViewThread;
    
    public GameRunner() {
        this.isGameRunning = false;
        
        messageQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);
        commandQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);
        
        CLIView cliView = new CLIView(messageQueue, commandQueue);
        gameViewThread = new Thread(cliView);
        gameViewThread.setDaemon(true);
    }

    public void start() {
        isGameRunning = true;
        gameViewThread.start();
        initializeGame();
        
        while(isGameRunning) {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                messageQueue.put("mess: this is a message");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
